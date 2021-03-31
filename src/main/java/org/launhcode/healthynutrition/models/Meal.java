package org.launhcode.healthynutrition.models;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Represents a row in the meal table in the database.
 */
@Entity
public class Meal extends AbstractEntity {

    private int goal;
    private int exercise;
    private int total;
    private int food;

    public Meal() {

    }

    public Meal(int goal, int exercise, int total) {
        this.goal = goal;
        this.exercise = exercise;
        this.total = total;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getExercise() {
        return exercise;
    }

    public void setExercise(int exercise) {
        this.exercise = exercise;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

// just do a simple calculation. no overthink.
    public void setMealCalculations() {
        ArrayList<Food> food = new ArrayList<>();
          this.total = this.goal - this.food + this.exercise;
//
//        let total = 0;
//        let food = Number(ArrayList<Food>);
//        ArrayList Food = new Arraylist<>;
//        let total = document.getElementById("goal"); let box2 = document.getElementById("food"); let box3 = document.getElementById("exercise");
//        let total = Number(goal) - Number(food) + Number(exercise);
//        box3.innerHTML = total;
    }
}
