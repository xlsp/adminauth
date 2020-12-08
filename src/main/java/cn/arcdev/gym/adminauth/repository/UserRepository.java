package cn.arcdev.gym.adminauth.repository;

import cn.arcdev.gym.adminauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
     * @param userName to search
     * @return user found by username
     */
    Optional<User> findByUsername(String userName);

    /**
     * Find a user and his roles by username.
     *
     * @param userName to search
     * @return a user with his roles
     */
    @Query("SELECT user FROM User user LEFT JOIN FETCH user.roles WHERE user.username = :username")
    Optional<User> findUserAndRolesByUsername(@Param("username") String userName);
}
