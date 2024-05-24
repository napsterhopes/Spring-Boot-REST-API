package SpringBoot_REST_Api.jpa;

import SpringBoot_REST_Api.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}