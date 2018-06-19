package com.zeros.backend.domain.exceptions;

public class AlreadySubscribedRestaurantException extends RuntimeException {

    public AlreadySubscribedRestaurantException(String message) {
        super(message);
    }

}
