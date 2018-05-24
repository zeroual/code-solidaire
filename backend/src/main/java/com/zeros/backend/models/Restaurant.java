package com.zeros.backend.models;

import com.zeros.backend.services.Route;

import java.util.List;

public class Restaurant extends Entity {

    private String name;
    private Location location;
    private float rating;
    private List<String> photosReference;
    private Route route;

    public Restaurant(String name, Location location, float rating, List<String> photos, Route route) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.photosReference = photos;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public float getRating() {
        return rating;
    }

    public List<String> getPhotosReference() {
        return photosReference;
    }

    public Route getRoute() {
        return route;
    }
}
