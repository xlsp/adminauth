package cn.arcdev.gym.adminauth.repository;

import cn.arcdev.gym.adminauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User repository.
 *
 * @author Kraken
 */
public interface UserRepository extends JpaRepository<Long, User> {
    /**
     * Find User by {@code username}.
     *
     * @param userName the username
     * @return User found by username, null otherwise.
     */
    Optional<User> findByUsername(String userName);
}
