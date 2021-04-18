package org.launhcode.healthynutrition.data;
import org.launhcode.healthynutrition.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer> {
    User findByEmail(String email);
    User findByResetPasswordToken(String token);
}
