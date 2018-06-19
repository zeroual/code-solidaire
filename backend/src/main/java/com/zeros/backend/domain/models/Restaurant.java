package com.zeros.backend.domain.models;

public class Restaurant extends Entity {

    private String name;
    private String address;
    private Double latitude;
    private Double longitude;

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(String name, String address, Double latitude, Double longitude) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getaddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
