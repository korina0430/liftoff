package org.launhcode.healthynutrition.controllers;

import org.launhcode.healthynutrition.data.RecipeRepository;
import org.launhcode.healthynutrition.models.Recipe;
import org.launhcode.healthynutrition.models.RecipeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private RecipeRepository recipeRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public SearchController() {

        columnChoices.put("all", "All");
        columnChoices.put("name", "Name");
        columnChoices.put("description", "Description");
        columnChoices.put("servingUnits", "ServingUnits");

    }


    @GetMapping("")
    public String search(Model model){
        model.addAttribute("columns", columnChoices);

        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Recipe> recipes;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            recipes = recipeRepository.findAll();
        } else {
            recipes = RecipeData.findByColumnAndValue(searchType, searchTerm, recipeRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Recipes with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("recipes", recipes);

        return "search";
    }

}

