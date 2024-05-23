package SpringBoot_REST_Api.jpa;

import SpringBoot_REST_Api.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
