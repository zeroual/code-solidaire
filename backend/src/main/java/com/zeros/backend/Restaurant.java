package com.zeros.backend;

import java.util.List;

public class Restaurant {

    private String name;
    private Location location;
    private float rating;
    private List<String> photosReference;

    Restaurant(String name, Location location, float rating, List<String> photos) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.photosReference = photos;
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
}
