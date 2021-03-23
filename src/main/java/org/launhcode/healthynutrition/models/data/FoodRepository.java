package org.launhcode.healthynutrition.models.data;

import org.launhcode.healthynutrition.models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food,Integer> {

}
