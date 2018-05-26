package com.zeros.backend.service;

public class Location {

    private double lat;
    private double lng;

    Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
