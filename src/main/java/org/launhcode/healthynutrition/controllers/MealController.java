package org.launhcode.healthynutrition.controllers;

import org.launhcode.healthynutrition.models.Food;
import org.launhcode.healthynutrition.models.Meal;
import org.launhcode.healthynutrition.models.data.FoodRepository;
import org.launhcode.healthynutrition.models.data.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// The controller needs to render this view. So you need to
// create a thymeleaf template that looks similar to the wiremock and return it from an endpoint in the controller
@Controller
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealRepository mealRepository;
//
    @Autowired
    private FoodRepository foodRepository;

//    List<Food> food = new ArrayList<>();
    @GetMapping
    public String getAddMealForm() {
        return "index";
    }

    @PostMapping("")
    public String displayAddMealForm(Model model, Meal meal, Food food) {
        model.addAttribute("title", "Add Meals");
        model.addAttribute(new Meal());
        model.addAttribute(new Food());
        mealRepository.save(meal);
        foodRepository.save(food);
        return "redirect:";
    }
// make if-elf or switch-case statements for calculations
    // add attributes from food model
    //make a method that stores user input and calculate what they've entered.
}

