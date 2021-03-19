package org.launhcode.healthynutrition.models;

import javax.persistence.*;
import java.util.ArrayList;

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

//    private boolean checkSkinType(String skinType, String facialType) {
//        if (skinType.equals("oily")) {
//            if (facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating")) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        else if (skinType.equals("combination")) {
//            if (facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating") || facialType.equals("Enzyme Peel")) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        else if (skinType.equals("normal")) {
//            return true;
//        }
//        else if (skinType.equals("dry")) {
//            if (facialType.equals("Rejuvenating") || facialType.equals("Hydrofacial")) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        else {
//            return true;
//        }
//    }
//
//    public void setAppropriateFacials(String skinType) {
//        ArrayList<String> facials = new ArrayList<String>();
//        facials.add("Microdermabrasion");
//        facials.add("Hydrofacial");
//        facials.add("Rejuvenating");
//        facials.add("Enzyme Peel");
//
//        for (int i = 0; i < facials.size(); i ++) {
//            if (checkSkinType(skinType,facials.get(i))) {
//                appropriateFacials.add(facials.get(i));
//            }
//        }
//    }
}
