package cn.arcdev.gym.adminauth.controller;

import cn.arcdev.core.dto.Response;
import cn.arcdev.core.exception.ApplicationException;
import cn.arcdev.gym.adminauth.constant.AdminAuthError;
import cn.arcdev.gym.adminauth.constant.RoleConstants;
import cn.arcdev.gym.adminauth.dto.request.SignUpRequest;
import cn.arcdev.gym.adminauth.entity.Role;
import cn.arcdev.gym.adminauth.entity.User;
import cn.arcdev.gym.adminauth.repository.RoleRepository;
import cn.arcdev.gym.adminauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * User controller.
 *
 * @author Kraken
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @GetMapping("/test")
    public String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName() + "  .. " + authentication.getCredentials() + "  .. " + authentication.getPrincipal();
    }

    /**
     * Register user.
     *
     * @param signUpRequest register request including username and password
     * @return register success
     */
    @PostMapping("/sign-up")
    public Response<Void> signUp(@RequestBody @Validated SignUpRequest signUpRequest) {
        User user = new User().setUsername(signUpRequest.getUsername()).setPassword(passwordEncoder.encode(signUpRequest.getPassword()))
                .setEnabled(true).setDeleted(false);
        List<Role> userRoles = new ArrayList<>(1);
        Role defaultRole = roleRepository.findByName(RoleConstants.DEFAULT_USER_ROLE_NAME)
                .orElseThrow(() -> new ApplicationException(AdminAuthError.NO_DEFAULT_ROLE, AdminAuthError.NO_DEFAULT_ROLE_MESSAGE));
        userRoles.add(defaultRole);
        user.setRoles(userRoles);
        userRepository.save(user);
        return new Response<>();
    }
}
