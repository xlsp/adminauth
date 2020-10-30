package cn.arcdev.gym.adminauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
        return "ok";
    }
}
