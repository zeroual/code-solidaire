package com.zeros.backend.models;

public class Restaurant extends Entity {

    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
