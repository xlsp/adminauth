package cn.arcdev.gym.adminauth.controller;

import cn.arcdev.gym.adminauth.bean.Response;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User controller.
 *
 * @author Kraken
 */
@RestController
public class UserController {
    @GetMapping("/test")
    public String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName() + "  .. " + authentication.getCredentials() + "  .. " + authentication.getPrincipal();
    }

    @PostMapping("/sign-up")
    public Response<>
}
