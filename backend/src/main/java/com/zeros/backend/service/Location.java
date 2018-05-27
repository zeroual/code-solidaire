package com.zeros.backend.service;

import com.google.maps.model.LatLng;

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
    
    LatLng toLatLng(){
    	return new LatLng(this.lat, this.lng);
    }
}
