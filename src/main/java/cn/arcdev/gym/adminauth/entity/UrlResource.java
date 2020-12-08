package cn.arcdev.gym.adminauth.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * URL resource (for authorization).
 *
 * @author Kraken
 */
@Entity
@Data
@Accessors(chain = true)
public class UrlResource {
    @Id
    private Integer id;
    private String regex;
}
