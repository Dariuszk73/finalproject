package pl.sda.java.project.finalproject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.java.project.finalproject.services.LoginService;


@Controller
public class LoginController {

private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginForm() {

        return "loginForm";
    }
    @GetMapping("/login-error")
    public String logoutUser() {
loginService.logout();
        return "invalidLogin";
    }

}



