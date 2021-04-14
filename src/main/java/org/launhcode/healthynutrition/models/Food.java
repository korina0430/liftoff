package org.launhcode.healthynutrition.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;


/**
 * Represents a row in the food table in the database.
 */
@Entity
public class Food extends AbstractEntity {

    private Integer breakfast;
    private Integer lunch;
    private Integer dinner;
    private Integer snacks;
    private Integer exercise;

    private Integer calorieGoal;
    private Integer calorieExercise;
    private Integer calorieFood;

    private Date date;
    private int id;

//    @ManyToOne
//    @JoinColumn(name="id")
//    @Cascade(CascadeType.ALL)
//    private User user;

    public Food() {

    }

    public Food(Integer breakfast, Integer lunch, Integer dinner, Integer snacks,
                Integer exercise, Integer calorieGoal,
                Integer calorieExercise, Integer calorieFood, Date date, int ID) {
        super();
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snacks = snacks;
        this.exercise = exercise;
        this.calorieGoal = calorieGoal;
        this.calorieExercise = calorieExercise;
        this.calorieFood = calorieFood;
        this.date = date;
        this.id = ID;
    }

    public Integer getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Integer breakfast) {
        this.breakfast = breakfast;
    }

    public Integer getLunch() {
        return lunch;
    }

    public void setLunch(Integer lunch) {
        this.lunch = lunch;
    }

    public Integer getDinner() {
        return dinner;
    }

    public void setDinner(Integer dinner) {
        this.dinner = dinner;
    }

    public Integer getSnacks() {
        return snacks;
    }

    public void setSnacks(Integer snacks) {
        this.snacks = snacks;
    }

    public Integer getExercise() {
        return exercise;
    }

    public void setExercise(Integer exercise) {
        this.exercise = exercise;
    }

    public Integer getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(Integer calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public Integer getCalorieExercise() {
        return calorieExercise;
    }

    public void setCalorieExercise(Integer calorieExercise) {
        this.calorieExercise = calorieExercise;
    }

    public Integer getCalorieFood() {
        return calorieFood;
    }

    public void setCalorieFood(Integer calorieFood) {
        this.calorieFood = calorieFood;
    }

    @DateTimeFormat(pattern="dd-MMM-YYYY")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer setTotal() {
        ArrayList<Integer> food = new ArrayList<Integer>();
        food.add(this.breakfast);
        food.add(this.lunch);
        food.add(this.dinner);
        food.add(this.snacks);
        food.add(this.exercise);

        int total = 0;

        for (int i = 0; i < food.size(); i++) {
                total += food.get(i);
            }
        return total;
    }

        public Integer setMealCalculations() {
        ArrayList<Integer> calorieTotal = new ArrayList<Integer>();
        calorieTotal.add(this.calorieFood);
        calorieTotal.add(this.calorieExercise);
        calorieTotal.add(this.calorieGoal);

        int sum = 0;

        for (int i = 0; i < calorieTotal.size(); i++) {
                sum += calorieTotal.get(i);

            }
        return sum;
    }


}