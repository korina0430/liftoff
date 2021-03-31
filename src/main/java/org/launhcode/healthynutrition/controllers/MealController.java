package org.launhcode.healthynutrition.controllers;

import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;
import org.launhcode.healthynutrition.models.Food;
import org.launhcode.healthynutrition.models.Meal;
import org.launhcode.healthynutrition.models.data.FoodRepository;
import org.launhcode.healthynutrition.models.data.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.*;


@Controller
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public String getAddMealForm() {
        return "meal";
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

//    @PostMapping
//    public String CalculateMealForm() {

//        return "redirect:";
//    }
// TODO: make if-else or switch-case statements for calculations
//class breakfast
//var totalCal = 0
//for loop(i=1;i++)
//    get user input = "Enter food item, if finished type "DONE""
//    var food = user input
//    totalCal = totalCal + food
//    if food equals done end
//breakfeast = totalCal

// TODO: add attributes from food model
    // total = goal - food + exercise
    // focus on the goal, food, exercise & total for now
// TODO: make a method that stores user input and calculate what they've entered.
}

