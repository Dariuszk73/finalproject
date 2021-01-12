package pl.sda.java.project.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.java.project.finalproject.services.UserContextService;

@Controller
public class MainPageController {
private final UserContextService userContextService;

    public MainPageController(UserContextService userContextService) {
        this.userContextService = userContextService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
model.addAttribute("loggedAs", userContextService.getCurrentlyLoggedEmail());
        return "mainPageView";
    }
}
