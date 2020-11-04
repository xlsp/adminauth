package cn.arcdev.gym.adminauth.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Admin role.
 *
 * @author Kraken
 */
@Entity
@Data
@Accessors(chain = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;
}
