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
import java.util.Optional;

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
        model.addAttribute("categoryError", "");
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        model.addAttribute(new Recipe());
        return "recipe/create";
    }

    @PostMapping("create")
    public String processCreateOrEditRecipeForm(@ModelAttribute @Valid Recipe recipe,
                                    Errors errors, Model model,
                                    @RequestParam(required = false) List<Integer> categories) {

        if (errors.hasErrors() || categories == null) {
            model.addAttribute("title", "Create Recipe");
            if (recipe.getId() > 0){
                model.addAttribute("title", "Edit Recipe");
            }
            if (categories == null){
                model.addAttribute("categoryError", "Category is required");

            }

            model.addAttribute("categories", recipeCategoryRepository.findAll());
            model.addAttribute(recipe);
            return "recipe/create";
        }

        List<RecipeCategory> recipeCategories =(List<RecipeCategory>) recipeCategoryRepository.findAllById(categories);
        recipe.setCategories(recipeCategories);
        recipeRepository.save(recipe);
        return "redirect:/";
    }
    @GetMapping("edit")
    public String getRecipeForm(Model model, @RequestParam int id){
        model.addAttribute("title", "Edit Recipe");
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        Optional<Recipe> existingRecipe =   recipeRepository.findById(id);
        if(existingRecipe.isPresent()) {
            model.addAttribute(existingRecipe.get());
            return "recipe/create";
        }
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteRecipe(@PathVariable int id){
        Optional<Recipe> existingRecipe =   recipeRepository.findById(id);
        if (existingRecipe.isPresent()){
            recipeRepository.delete(existingRecipe.get());
        }
        return "redirect:/";
    }

}
