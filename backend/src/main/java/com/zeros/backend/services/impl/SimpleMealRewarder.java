package com.zeros.backend.services.impl;

import com.zeros.backend.exceptions.RestaurantNotFoundException;
import com.zeros.backend.models.Meal;
import com.zeros.backend.repositories.MealRepository;
import com.zeros.backend.repositories.RestaurantRepository;
import com.zeros.backend.services.MealRewarder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SimpleMealRewarder implements MealRewarder {

    private RestaurantRepository restaurantRepository;
    private MealRepository mealRepository;

    @Autowired
    public SimpleMealRewarder(RestaurantRepository restaurantRepository,
                              MealRepository mealRepository) {
        this.restaurantRepository = restaurantRepository;
        this.mealRepository = mealRepository;
    }

    public Meal rewardMeal(Long restaurantId, Long userId) throws RestaurantNotFoundException {
        boolean restaurantNotExists = !restaurantRepository.exists(restaurantId);
        if (restaurantNotExists)
            throw new RestaurantNotFoundException("The restaurant '" + restaurantId + "' doesn't exist !" );
        Meal meal = new Meal(userId, restaurantId, LocalDateTime.now());
        return mealRepository.save(meal);
    }

}
