package com.zeros.backend.domain.services;

import com.zeros.backend.domain.exceptions.RestaurantNotFoundException;
import com.zeros.backend.domain.models.Meal;

public interface MealRewarder {

    Meal rewardMeal(Long restaurantId, Long userId) throws RestaurantNotFoundException;
}
