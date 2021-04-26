package org.launhcode.healthynutrition.controllers;

import org.launhcode.healthynutrition.data.RecipeRepository;
import org.launhcode.healthynutrition.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;


@Controller
@RequestMapping("/")



public class HomeController {


    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("title", "My Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());

        return  "index";
    }

    @GetMapping("view/{id}")
    public String viewRecipe(@PathVariable int id, Model model){

        Optional<Recipe> existingRecipe = recipeRepository.findById(id);
        if(existingRecipe.isPresent()){
            Recipe recipe = (Recipe) existingRecipe.get();
            model.addAttribute("recipe", recipe);
            return "view";
        } else {
            return "redirect:../";
        }


    }

}