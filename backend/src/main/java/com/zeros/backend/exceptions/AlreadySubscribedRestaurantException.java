package com.zeros.backend.exceptions;

public class AlreadySubscribedRestaurantException extends RuntimeException {

    public AlreadySubscribedRestaurantException() {
    }

    public AlreadySubscribedRestaurantException(String message) {
        super(message);
    }

}
