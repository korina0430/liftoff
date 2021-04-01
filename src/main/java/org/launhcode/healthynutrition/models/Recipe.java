package org.launhcode.healthynutrition.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name/Title is required")
    @Size(min = 3, max = 50, message = "Name must be in 3 to 50 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 150, message = "Description must be in 5 to 150 characters")
    private String description;

    @Min(value=1, message = "Minimum calories should be 1")
    private int calories;

    @NotBlank(message = "Preparation steps are required")
    @Size(min = 10, max = 5000, message = "Directions must be in 10 to 5000 characters")
    private String directions;

    @NotBlank(message = "Serving units is required")
    @Size(min = 5, max = 100, message = "Serving units must be in 5 to 100 characters")
    private String servingUnits;

    @ManyToMany
    private List<RecipeCategory> categories;

    public Recipe() {}

    public Recipe(String name, String description, int calories, String directions,
                  String servingUnits, List<RecipeCategory> categories) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.directions = directions;
        this.servingUnits = servingUnits;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getServingUnits() {
        return servingUnits;
    }

    public void setServingUnits(String servingUnits) {
        this.servingUnits = servingUnits;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }
}
