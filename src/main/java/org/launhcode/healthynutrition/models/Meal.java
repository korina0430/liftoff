package org.launhcode.healthynutrition.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

/**
 * Represents a row in the meal table in the database.
 */
//@Entity
//public class Meal extends AbstractEntity {
//
////    ArrayList<Food> newFood = new ArrayList<>();
//
//    private int goal;
//    private int physicalActivity;
//    private int total;
//    private int food;
//
//    public Meal() {
//
//    }
//
//    public Meal(int goal, int exercise, int total, int food) {
//        super();
//        this.goal = goal;
//        this.physicalActivity = exercise;
//        this.total = total;
//        this.food = food;
//    }
//
//    public int getGoal() {
//        return goal;
//    }
//
//    public void setGoal(int goal) {
//        this.goal = goal;
//    }
//
//    public int getPhysicalActivity() {
//        return physicalActivity;
//    }
//
//    public void setPhysicalActivity(int exercise) {
//        this.physicalActivity = exercise;
//    }
//
//    public int getFood() {
//        return food;
//    }
//
//    public void setFood(int food) {
//        this.food = food;
//    }
//
//    public int getTotal() {
//        return total;
//    }
//
//    public void setTotal(int total) {
//        this.total = total;
//    }
//
//    // just do a simple calculation. no overthink.
//    public Integer setMealCalculations() {
//        ArrayList<Integer> mealTotal = new ArrayList<Integer>();
//        mealTotal.add(this.food);
//        mealTotal.add(this.physicalActivity);
//        mealTotal.add(this.goal);
//
//        int sum = 0;
//
//        for (int i = 0; i < mealTotal.size(); i++) {
//            if (mealTotal.isEmpty()) {
//                mealTotal.add(mealTotal.get(i));
//                sum += mealTotal.get(i);
//            } else {
//                sum += mealTotal.get(i);
//            }
//            //
//        }
//        return sum;
//    }
//}

// worry about mappings first.
// hardcode year, write month/day/associated with user
// make the user DB connect with the food DB
// one table for whole page
// git stash for the calendar
// write authentication filter code