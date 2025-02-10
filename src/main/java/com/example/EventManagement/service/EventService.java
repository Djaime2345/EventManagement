package com.example.EventManagement.service;

import com.example.EventManagement.model.Event;
import com.example.EventManagement.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final List<Event> events = new ArrayList<>();
    private Long nextEventId = 1L;
    private Long nextUserId = 1L;

    public EventService(){
        events.add(new Event(nextEventId++, "Event 1"));
        events.add(new Event(nextEventId++, "Event 2"));
    }
    public List<Event> getAllEvents(){
        return events;
    }

    public Event registerUser(User user, String eventName){
        user.setId(nextUserId++);

        Optional<Event> optionalNote = events.stream()
                .filter(note -> note.getEventName().equals(eventName))
                .findFirst();

        if (optionalNote.isPresent()){
            Event event = optionalNote.get();
            event.addUser(user);
            return event;
        }
        return null;
    }

    public Event unregisterUser(String mail, String eventName){
        Optional<Event> optionalNote = events.stream()
                .filter(note -> note.getEventName().equals(eventName))
                .findFirst();

        if (optionalNote.isPresent()){
            Event event = optionalNote.get();
            event.deleteUser(mail);
            return event;
        }
        return null;
    }
}
