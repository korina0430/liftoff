package org.launhcode.healthynutrition.models.data;

import org.launhcode.healthynutrition.models.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal,Integer> {

}
