package com.zeros.backend.domain.models;

import java.time.LocalDateTime;

public class Meal extends Entity {


    private Long userId;
    private Long restaurantId;
    private LocalDateTime date;

    public Meal(Long userId, Long restaurantId, LocalDateTime date) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
