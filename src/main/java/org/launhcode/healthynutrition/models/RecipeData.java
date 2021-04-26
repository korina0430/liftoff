package org.launhcode.healthynutrition.models;

import java.util.ArrayList;

public class RecipeData {

    public static ArrayList<Recipe> findByColumnAndValue(String column, String value, Iterable<Recipe> allRecipes) {

        ArrayList<Recipe> results = new ArrayList<>();



        if (value.equalsIgnoreCase("all")){
            return (ArrayList<Recipe>) allRecipes;
        }

        if (column.equals("all")){
            results = findByValue(value, allRecipes);
            return results;
        }
        for (Recipe recipe : allRecipes) {

            String searchString = getFieldValue(recipe, column);

            if (searchString != null && searchString.toLowerCase().contains(value.toLowerCase())) {
              
                results.add(recipe);
            }
        }

        return results;
    }

    public static String getFieldValue(Recipe recipe, String fieldName){

        String searchValue;
        switch (fieldName.toLowerCase()) {
            case "name":
                searchValue = recipe.getName();
                break;
            case "description":
                searchValue = recipe.getDescription();
                break;
            default:
                searchValue = recipe.getServingUnits();
        }
        return searchValue;
    }

    /**
     * Search all Recipe fields for the given term.
     *
     * @param value The search term to look for.
     * @param allRecipes The list of recipes to search.
     * @return      List of all recipes with at least one field containing the value.
     */
    public static ArrayList<Recipe> findByValue(String value, Iterable<Recipe> allRecipes) {

        String searchWord = value.toLowerCase();
        ArrayList<Recipe> results = new ArrayList<>();

        for (Recipe recipe : allRecipes) {

            if (recipe.getName().toLowerCase().contains(searchWord)) {
                results.add(recipe);
            } else if (recipe.getDescription().toLowerCase().contains(searchWord)) {
                results.add(recipe);
            } else if (recipe.getServingUnits().toLowerCase().contains(searchWord)) {
                results.add(recipe);
            } else if (recipe.toString().toLowerCase().contains(searchWord)) {
              
                results.add(recipe);
            }

        }

        return results;
    }


}



