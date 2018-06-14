package com.zeros.backend.services;

import com.zeros.backend.models.Restaurant;

public interface RestaurantSubscriber {

    Restaurant subscribe(Restaurant restaurant);
}
