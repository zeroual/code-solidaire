package com.zeros.backend.service;

import java.util.List;

public class Restaurant {

    private String name;
    private Location location;
    private float rating;
    private List<String> photosReference;
    private Route route;

    Restaurant(String name, Location location, float rating, List<String> photos,
               Route route) {
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
