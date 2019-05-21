package com.github.tanpatrick.model;

import java.util.UUID;

public class User {

    private String id;
    private String lastName;
    private String firstName;

    public User(String lastName, String firstName) {
        this.id = UUID.randomUUID().toString();
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
