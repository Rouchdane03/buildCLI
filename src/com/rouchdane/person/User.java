package com.rouchdane.person;

import java.util.UUID;

public class User {

    private UUID id;

    private String name;

    private boolean booked;

    {
        this.booked = false;
    }

    public User(){}

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ",name='" + name + '\'' +
                '}';
    }
}
