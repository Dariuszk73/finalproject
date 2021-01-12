package pl.sda.java.project.finalproject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LoginController {


    @GetMapping("/login")
    public String showLoginForm() {

        return "loginForm";
    }
    @GetMapping("/login-error")
    public String logoutUser() {

        return "invalidLogin";
    }

}



