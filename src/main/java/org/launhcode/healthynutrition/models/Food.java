package org.launhcode.healthynutrition.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DecimalFormat;
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

    private int getValueInRange(int value, int min, int max) {
        return Math.min(Math.max(min, value), max);
    }

    private float getValueInRange(float value, float min, float max) {
        return Math.min(Math.max(min, value), max);
    }

    private HashMap<String, Float> calculateTotalCalories(double breakfast, double lunch, double dinner,
                                                          double snacks, float exercise) {
        float kcalBreakfast = (float) (breakfast * 7);
        float kcalLunch = (float) (lunch * 7);
        float kcalDinner = (float) (dinner * 7);
        float kcalSnacks = (float) (snacks * 2);
        float kcalTotal = kcalBreakfast + kcalDinner +kcalLunch + kcalSnacks - exercise;
        HashMap<String, Float> result = new HashMap<>();


        if (kcalTotal <= 0) {
            return result;
        }

        result.put("energy", roundMacroEnergy(kcalTotal));
        result.put("breakfast", roundMacroCal((float) kcalBreakfast));
        result.put("dinner", roundMacroCal((float) kcalDinner));
        result.put("lunch", roundMacroCal(kcalLunch));
        result.put("snacks", roundMacroEnergy(kcalSnacks));
        return result;
    }

    private float roundMacroCal(float floatValue) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return (Float.valueOf(decimalFormat.format(floatValue)));
    }

    private float roundMacroEnergy(float floatValue) {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        return (Float.valueOf(decimalFormat.format(floatValue)));
    }
}