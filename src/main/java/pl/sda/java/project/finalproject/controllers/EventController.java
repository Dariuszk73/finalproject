package pl.sda.java.project.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.java.project.finalproject.dtos.NewEventForm;
import pl.sda.java.project.finalproject.services.EventService;
import pl.sda.java.project.finalproject.services.UserContextService;

import javax.validation.Valid;


@Controller
public class EventController {
    private final UserContextService userContextService;
    private final EventService eventService;

    private final String LOGGED_AS_MODEL_KEY = "loggedAs";

    public EventController(UserContextService userContextService, EventService eventService) {
        this.userContextService = userContextService;
        this.eventService = eventService;
    }
    @GetMapping("/add/event")
    public String showEventForm(Model model){
        NewEventForm newEventForm = new NewEventForm();
        model.addAttribute("newEventForm", newEventForm);
        return "eventForm";
    }

    @PostMapping("/add/event")
    public String showEventFormSubmit(@ModelAttribute @Valid NewEventForm newEventForm,
                                BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "eventForm";
        }
        eventService.addEvent(newEventForm);
        return "mainPageViev";
    }
}
