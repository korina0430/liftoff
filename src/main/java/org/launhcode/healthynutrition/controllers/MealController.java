package org.launhcode.healthynutrition.controllers;

import org.launhcode.healthynutrition.models.Food;
import org.launhcode.healthynutrition.models.Meal;
import org.launhcode.healthynutrition.models.data.FoodRepository;
import org.launhcode.healthynutrition.models.data.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public String getAddMealForm() {
        return "index";
    }

    @PostMapping
    public String displayAddMealForm(Model model, Meal meal, Food food) {
        model.addAttribute("title", "Add Meals");
        model.addAttribute(new Meal());
        model.addAttribute(new Food());
        mealRepository.save(meal);
        foodRepository.save(food);
        return "redirect:";
    }
// TODO: make if-else or switch-case statements for calculations
// TODO: add attributes from food model
// TODO: make a method that stores user input and calculate what they've entered.
}

