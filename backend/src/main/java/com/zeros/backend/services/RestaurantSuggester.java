package com.zeros.backend.services;

import java.util.List;

public interface RestaurantSuggester {

    List<RestaurantSuggestion> getNearbyRestaurant();
}
