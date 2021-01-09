package pl.sda.java.project.finalproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController {
    @GetMapping("/login")
    public String showLoginForm() {

        return "loginForm";
    }

}
