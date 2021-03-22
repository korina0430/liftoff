package org.launhcode.healthynutrition.controllers;

import org.launhcode.healthynutrition.data.RecipeCategoryRepository;
import org.launhcode.healthynutrition.data.RecipeRepository;
import org.launhcode.healthynutrition.models.Recipe;
import org.launhcode.healthynutrition.models.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

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

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                    Errors errors, Model model,
                                    @RequestParam(required = false) List<Integer> categories) {
        if (errors.hasErrors() || categories.isEmpty() ) {
            model.addAttribute("title", "Create Recipe");
            model.addAttribute("categories", recipeCategoryRepository.findAll());
            model.addAttribute(newRecipe);
            return "recipe/create";
        }

        List<RecipeCategory> recipeCategories =(List<RecipeCategory>) recipeCategoryRepository.findAllById(categories);
        newRecipe.setCategories(recipeCategories);
        recipeRepository.save(newRecipe);
        return "redirect:/";
    }
}
