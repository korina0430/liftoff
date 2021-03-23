package org.launhcode.healthynutrition.models;

import javax.persistence.*;

/**
 * Represents a row in the meal table in the database.
 */
@Entity
public class Meal extends AbstractEntity {

        private int goal;
        private String exercise;
        private int food;
        private int total;

        public int getGoal() {
            return goal;
        }

        public void setGoal(int goal) {
            this.goal = goal;
        }

        public String getExercise() {
            return exercise;
        }

        public void setCurrent(int current) {
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

}
