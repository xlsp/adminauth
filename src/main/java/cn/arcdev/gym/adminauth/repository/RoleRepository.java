package cn.arcdev.gym.adminauth.repository;

import cn.arcdev.gym.adminauth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Role repository.
 *
 * @author Kraken
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    /**
     * Find role by role name.
     *
     * @param roleName to search
     * @return role
     */
    Optional<Role> findByName(String roleName);

    /**
     * Find role and url resources by role name.
     *
     * @param roleName to search
     * @return role and url resources
     */
    @Query("SELECT role FROM Role role LEFT JOIN FETCH role.urlResources WHERE role.name = :roleName")
    Optional<Role> findRoleAndUrlResourcesByName(@Param("roleName") String roleName);
}
