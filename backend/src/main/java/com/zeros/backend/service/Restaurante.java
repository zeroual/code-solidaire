package com.zeros.backend.service;

import java.util.List;

public class Restaurante {

    private String name;
    private Location location;
    private float rating;
    private List<String> photosReference;
    private Route distance;

    Restaurante(String name, Location location, float rating, List<String> photos, 
    		Route distance) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.photosReference = photos;
        this.distance = distance;
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

	public Route getDistance() {
		return distance;
	}    
}
