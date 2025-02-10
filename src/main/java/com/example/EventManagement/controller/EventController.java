package com.example.EventManagement.controller;

import com.example.EventManagement.model.Event;
import com.example.EventManagement.model.User;
import com.example.EventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event addUsertoEvent(@Valid @RequestBody User user, String eventName){
        return this.eventService.registerUser(user, eventName);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getEventRegistrations(){
        return this.eventService.getAllEvents();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Event cancelRegistration(@Valid @RequestBody String email){
        return this.cancelRegistration(email);
    }
}
