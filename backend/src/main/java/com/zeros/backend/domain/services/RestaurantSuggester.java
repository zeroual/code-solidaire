package com.zeros.backend.domain.services;

import java.util.List;

public interface RestaurantSuggester {

    List<RestaurantSuggestion> getNearbyRestaurant(double latitude, double longitude);
}
