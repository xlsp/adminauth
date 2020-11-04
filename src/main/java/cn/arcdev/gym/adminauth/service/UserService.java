package cn.arcdev.gym.adminauth.service;

import cn.arcdev.gym.adminauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * User service.
 *
 * @author Kraken
 */
@Service
@RequiredArgsConstructor
public class UserService {
    protected final UserRepository userRepository;
    protected final PasswordEncoder passwordEncoder;

    public void addUser(String username, String password) {

    }
}
