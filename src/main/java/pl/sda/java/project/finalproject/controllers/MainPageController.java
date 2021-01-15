package pl.sda.java.project.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.java.project.finalproject.services.LoginService;
import pl.sda.java.project.finalproject.services.UserContextService;

@Controller
public class MainPageController {
    private final UserContextService userContextService;
    private final LoginService loginService;

    public MainPageController(UserContextService userContextService, LoginService loginService) {
        this.userContextService = userContextService;
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("loggedAs", userContextService.getCurrentlyLoggedEmail());
        model.addAttribute("userLogged", loginService.isLogged());
        model.addAttribute("userInfo", loginService.getUserSessionDto());
        return "mainPageView";
    }
}
