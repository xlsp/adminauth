package cn.arcdev.gym.adminauth.repository;

import cn.arcdev.gym.adminauth.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Role repository.
 *
 * @author Kraken
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
