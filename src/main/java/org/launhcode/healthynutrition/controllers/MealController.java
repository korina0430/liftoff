package org.launhcode.healthynutrition.controllers;

import org.launhcode.healthynutrition.models.Food;
import org.launhcode.healthynutrition.models.data.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/calorietracking")
public class MealController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public String getAddMealForm() {
        return "calorietracking";
    }

    @PostMapping
    public String displayAddMealForm(Model model, Food food) {
        model.addAttribute("date", food.getDate());
        model.addAttribute("title", "Add Meals");
        foodRepository.save(food);
        return "redirect:";
    }

    @GetMapping("/calendar")
    public String getCalendar() {
        return "calendar.html";
    }

    @PostMapping("/calendar")
    public String displayCalendar() {
        return "/calendar";
    }
}

