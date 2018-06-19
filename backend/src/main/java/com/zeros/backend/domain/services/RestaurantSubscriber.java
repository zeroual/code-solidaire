package com.zeros.backend.domain.services;

import com.zeros.backend.domain.models.Restaurant;

public interface RestaurantSubscriber {

    Restaurant subscribe(Restaurant restaurant);
}
