package pl.sda.java.project.finalproject.services;

import org.springframework.stereotype.Service;
import pl.sda.java.project.finalproject.dao.EventRepository;
import pl.sda.java.project.finalproject.dao.UserRepository;
import pl.sda.java.project.finalproject.dtos.NewEventForm;
import pl.sda.java.project.finalproject.entities.EventEntity;
import pl.sda.java.project.finalproject.entities.UserEntity;
import pl.sda.java.project.finalproject.exceptions.UserDoesntExistException;

import javax.transaction.Transactional;

@Service
public class EventService {
    private final UserContextService userContextService;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public EventService(UserContextService userContextService, UserRepository userRepository, EventRepository eventRepository) {
        this.userContextService = userContextService;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @Transactional
    public void addEvent(NewEventForm newEventForm){
    final String currentLoggedUser =userContextService.getCurrentlyLoggedEmail();

    final UserEntity user = userRepository.findUserEntityByEmail(currentLoggedUser)
            .orElseThrow(() -> new UserDoesntExistException(currentLoggedUser));

    final EventEntity eventEntity = new EventEntity();

    eventEntity.setTitle(newEventForm.getTitle());
        eventEntity.setStartDate(newEventForm.getStartDate());
        eventEntity.setEndDate(newEventForm.getEndDate());
        eventEntity.setDescription(newEventForm.getDescription());
        eventEntity.setUserEntity(user);

    eventRepository.save(eventEntity);
    }

}
