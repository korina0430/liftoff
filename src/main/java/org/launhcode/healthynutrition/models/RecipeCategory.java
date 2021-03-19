package org.launhcode.healthynutrition.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be in 3 to 50 characters")
    private String name;
    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 50, message = "Description must be in 5 to 50 characters")
    private String description;

    @ManyToMany(mappedBy = "categories")
    private List<Recipe> recipes;

    public RecipeCategory () {}

    public RecipeCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

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
}
