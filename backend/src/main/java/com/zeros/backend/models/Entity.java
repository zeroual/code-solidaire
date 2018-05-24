package com.zeros.backend.models;

import java.io.Serializable;

public class Entity implements Serializable {

    protected Long id;

    public Entity() {
    }

    public Entity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
