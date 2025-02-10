package com.example.EventManagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class User {
    private Long id;
    @NotBlank(message = "Name must be provided")
    private String name;

    @Email(message = "Email must be a valid email format")
    private String mail;

    public User(Long id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
