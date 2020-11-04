package cn.arcdev.gym.adminauth.service;

import cn.arcdev.gym.adminauth.bean.SecurityUser;
import cn.arcdev.gym.adminauth.domain.User;
import cn.arcdev.gym.adminauth.repository.RoleRepository;
import cn.arcdev.gym.adminauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementation for spring security {@code UserDetailsService}.
 *
 * @author Kraken
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    protected final UserRepository userRepository;
    protected final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found."));
        return new SecurityUser(user);
    }
}
