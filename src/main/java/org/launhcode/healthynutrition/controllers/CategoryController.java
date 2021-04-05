package org.launhcode.healthynutrition.controllers;

import org.launhcode.healthynutrition.data.RecipeCategoryRepository;
import org.launhcode.healthynutrition.models.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("recipeCategory")
public class CategoryController {

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @GetMapping("add")
    public String displayCategoryForm(Model model){
        model.addAttribute("title", "Add Category");
        model.addAttribute(new RecipeCategory());
        return "recipeCategory/add";
    }



    @PostMapping("add")
    public String processCategoryForm(@ModelAttribute @Valid RecipeCategory recipeCategory,Errors errors,Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Category");
            model.addAttribute(recipeCategory);
            return "recipeCategory/add";
        }
            recipeCategoryRepository.save(recipeCategory);
        return "redirect:/recipe/create";
    }
}
