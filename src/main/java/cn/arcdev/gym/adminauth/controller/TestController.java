package cn.arcdev.gym.adminauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/f4")
    public String test() {
        return "ok";
    }
}
