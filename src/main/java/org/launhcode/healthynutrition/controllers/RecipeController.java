package org.launhcode.healthynutrition.controllers;

import org.launhcode.healthynutrition.data.RecipeCategoryRepository;
import org.launhcode.healthynutrition.data.RecipeRepository;
import org.launhcode.healthynutrition.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recipe")
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @GetMapping("create")
    public String displayCreateRecipeForm(Model model){
        model.addAttribute("title", "Create Recipe");
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        model.addAttribute(new Recipe());
        return "recipe/create";
    }
}
