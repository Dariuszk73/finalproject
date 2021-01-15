package pl.sda.java.project.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.java.project.finalproject.dtos.EventShortInfoDto;
import pl.sda.java.project.finalproject.services.EventService;
import pl.sda.java.project.finalproject.services.LoginService;
import pl.sda.java.project.finalproject.services.UserContextService;

import java.util.List;

@Controller
public class MainPageController {
    private final UserContextService userContextService;
    private final LoginService loginService;
    private final EventService eventService;

    public MainPageController(UserContextService userContextService, LoginService loginService, EventService eventService) {
        this.userContextService = userContextService;
        this.loginService = loginService;
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("loggedAs", userContextService.getCurrentlyLoggedEmail());
        model.addAttribute("userLogged", loginService.isLogged());
        model.addAttribute("userInfo", loginService.getUserSessionDto());
        List<EventShortInfoDto> eventShortInfoDtos = eventService.getCurrentAndFutureEvent();
        model.addAttribute("events", eventShortInfoDtos);
        return "mainPageView";
    }
}
