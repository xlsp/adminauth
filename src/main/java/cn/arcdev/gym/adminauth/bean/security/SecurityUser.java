package cn.arcdev.gym.adminauth.bean.security;

import cn.arcdev.gym.adminauth.entity.Role;
import cn.arcdev.gym.adminauth.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * User for spring security authentication.
 *
 * @author Kraken
 */
@Data
@Accessors(chain = true)
public class SecurityUser implements UserDetails {
    private String username;
    private String password;
    private boolean enabled;
    private List<GrantedAuthority> authorities;

    /**
     * Constructor.
     */
    public SecurityUser() {
        this.authorities = new LinkedList<>();
    }

    /**
     * Constructor.
     *
     * @param user Gym admin user
     */
    public SecurityUser(User user) {
        this.authorities = new LinkedList<>();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.getEnabled();
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            this.authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
