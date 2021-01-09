package pl.sda.java.project.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showRegisterForm() {

        return "registerForm";
    }

    @PostMapping("/register")
    public String submitRegisterForm(@RequestParam String email,
                                     @RequestParam String name,
                                     @RequestParam String password) {

        return "registeredUserThankyouPage";
    }
}
