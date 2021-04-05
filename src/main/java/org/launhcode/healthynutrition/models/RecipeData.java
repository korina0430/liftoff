package org.launhcode.healthynutrition.models;

import java.util.ArrayList;

public class RecipeData {

    public static ArrayList<Recipe> findByColumnAndValue(String column, String value, Iterable<Recipe> allRecipes) {

        ArrayList<Recipe> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Recipe>) allRecipes;
        }

        if (column.equals("all")){
            results = findByValue(value, allRecipes);
            return results;
        }
        for (Recipe recipe : allRecipes) {

            String aValue = getFieldValue(recipe, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(recipe);
            }
        }

        return results;
    }

    public static String getFieldValue(Recipe recipe, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = recipe.getName();
        } else if (fieldName.equals("description")){
            theValue = recipe.getDescription().toString();
        } else {
            theValue = recipe.getServingUnits().toString();
        }

        return theValue;
    }

    /**
     * Search all Recipe fields for the given term.
     *
     * @param value The search term to look for.
     * @param allRecipes The list of recipes to search.
     * @return      List of all recipes with at least one field containing the value.
     */
    public static ArrayList<Recipe> findByValue(String value, Iterable<Recipe> allRecipes) {
        String lower_val = value.toLowerCase();

        ArrayList<Recipe> results = new ArrayList<>();

        for (Recipe recipe : allRecipes) {

            if (recipe.getName().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            } else if (recipe.getDescription().toString().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            } else if (recipe.getServingUnits().toString().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            } else if (recipe.toString().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            }

        }

        return results;
    }


}



