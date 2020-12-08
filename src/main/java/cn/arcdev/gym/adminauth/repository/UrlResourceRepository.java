package cn.arcdev.gym.adminauth.repository;

import cn.arcdev.gym.adminauth.entity.UrlResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlResourceRepository extends JpaRepository<UrlResource, Integer> {
}
