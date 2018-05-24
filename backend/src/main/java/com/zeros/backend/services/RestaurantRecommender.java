package com.zeros.backend.services;

import com.zeros.backend.models.Restaurant;

import java.util.List;

public interface RestaurantRecommender {

    List<Restaurant> getNearbyRestaurant();
}
