package org.launhcode.healthynutrition.data;

import org.launhcode.healthynutrition.models.RecipeCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
}
