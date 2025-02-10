package com.example.EventManagement.model;

import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;

public class Event {
    private Long id;

    @NotBlank(message = "Name must be provided")
    private String eventName;

    private ArrayList<User> userRegisters;

    public Event(Long id, String eventName) {
        this.id = id;
        this.eventName = eventName;
        this.userRegisters = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void addUser(User user) {
        this.userRegisters.add(user);
    }

    public ArrayList<User> getUserRegisters(){
        return this.userRegisters;
    }

    public void deleteUser(String mail) {
        this.userRegisters.removeIf(user -> user.getMail().equals(mail));
    }
}
