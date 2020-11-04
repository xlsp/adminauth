package cn.arcdev.gym.adminauth.repository;

import cn.arcdev.gym.adminauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User repository.
 *
 * @author Kraken
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find User by {@code username}.
     *
     * @param userName the username
     * @return User found by username, null otherwise.
     */
    Optional<User> findByUsername(String userName);
}
