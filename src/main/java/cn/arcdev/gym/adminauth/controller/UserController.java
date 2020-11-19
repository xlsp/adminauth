package cn.arcdev.gym.adminauth.controller;

import cn.arcdev.core.dto.Response;
import cn.arcdev.gym.adminauth.dto.request.SignUpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Response<SignUpRequest> signUp(@RequestBody @Validated SignUpRequest signUpRequest) {
        Response<SignUpRequest> response = new Response<>();
        response.setStatus(0);
        response.setData(signUpRequest);
        return response;
    }
}
