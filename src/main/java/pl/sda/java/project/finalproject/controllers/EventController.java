package pl.sda.java.project.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.java.project.finalproject.dtos.CommentInfoDto;
import pl.sda.java.project.finalproject.dtos.EventShortInfoDto;
import pl.sda.java.project.finalproject.dtos.request.NewEventCommentForm;
import pl.sda.java.project.finalproject.dtos.request.NewEventForm;
import pl.sda.java.project.finalproject.model.SearchPeriod;
import pl.sda.java.project.finalproject.services.EventService;
import pl.sda.java.project.finalproject.services.UserContextService;


import javax.validation.Valid;
import java.util.List;


@Controller
public class EventController {

    private final EventService eventService;
    private final UserContextService userContextService;

    public EventController(EventService eventService, UserContextService userContextService) {
        this.eventService = eventService;
        this.userContextService = userContextService;
    }

    @GetMapping("/add/event")
    public String showEventForm(Model model) {
        NewEventForm newEventForm = new NewEventForm();
        model.addAttribute("newEventForm", newEventForm);
        return "events/eventForm";
    }

    @PostMapping("/add/event")
    public String showEventFormSubmit(@ModelAttribute @Valid NewEventForm newEventForm,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/eventForm";
        }
        eventService.addEvent(newEventForm);
        return "mainPageView";
    }

    @GetMapping("/actual-events")
    public String showActualEvents(Model model) {

        List<EventShortInfoDto> actualEvents = eventService.getCurrentAndFutureEvent();

        model.addAttribute("allActualEvents", actualEvents);

        return "events/actualEventsPage";
    }

    @GetMapping("/search-event")
    public String searchEvent(@RequestParam String title, @RequestParam SearchPeriod timePeriod
            , Model model) {
        model.addAttribute("title", title);
        model.addAttribute("timePeriod", timePeriod);
        model.addAttribute("foundEvents", eventService.getEventsContaining(title, timePeriod));

        return "events/foundEventsView";
    }

    @GetMapping("/events/{eventId}")
    public String getSingleEvent(@PathVariable Long eventId, Model model) {
        final NewEventCommentForm newEventCommentForm = new NewEventCommentForm();
        EventShortInfoDto singleEventInfo = eventService.getAllInformationEvent(eventId);
        List<CommentInfoDto> commentInfo = eventService.getAllComments(eventId);

        model.addAttribute("event", singleEventInfo);
        model.addAttribute("newEventCommentForm", newEventCommentForm);
        model.addAttribute("comments", commentInfo);
        model.addAttribute("isSignedUp", eventService.isSignedUp(eventId
                , userContextService.getCurrentlyLoggedEmail()));

        return "/events/singleEventView";
    }

    @PostMapping("/events/{eventId}/comment/add")
    public String addNewComment(@PathVariable Long eventId,
                                @ModelAttribute @Valid
                                        NewEventCommentForm newEventCommentForm,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "events/singleEventView" + eventId;
        }

        eventService.addNewComment(newEventCommentForm, eventId);

        return "redirect:/events/" + eventId;
    }
    @PostMapping("/events/{eventId}/sign-up")
    public String signedUpForEvent(@PathVariable Long eventId){

eventService.signedUp(eventId, userContextService.getCurrentlyLoggedEmail() );

return "events/singleEventView" + eventId;
    }
}