package pl.sda.java.project.finalproject.controllers;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.java.project.finalproject.services.LoginService;

@Controller
public class LoginController {
    private final LoginService loginService;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LoginController.class);

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginForm() {

        return "loginForm";
    }
@PostMapping("/login-submit-data")
    public String showLoginFormAfterSubmit(
            @RequestParam String username,
            @RequestParam String password){
    try {
        loginService.loginUser(username, password);
    } catch (Exception e) {
        log.warn("Couldn't log user in: {}", e.getMessage(), e);
        return "redirect:/login";
    }

        return "redirect:/users-by-email?email=tt";
}


}
