package com.zeros.backend.domain.exceptions;

public class RestaurantNotFoundException extends Exception {

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
