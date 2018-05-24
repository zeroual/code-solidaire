package com.zeros.backend.services;

import com.zeros.backend.exceptions.RestaurantNotFoundException;
import com.zeros.backend.models.Meal;

public interface MealRewarder {

    Meal rewardMeal(Long restaurantId, Long userId) throws RestaurantNotFoundException;
}
