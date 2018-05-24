package com.zeros.backend.exceptions;

public class RestaurantNotFoundException extends Exception {

    public RestaurantNotFoundException() {
    }

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
