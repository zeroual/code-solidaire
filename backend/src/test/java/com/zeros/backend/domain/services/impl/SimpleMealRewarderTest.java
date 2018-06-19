package com.zeros.backend.domain.services.impl;

import com.zeros.backend.domain.exceptions.RestaurantNotFoundException;
import com.zeros.backend.domain.models.Meal;
import com.zeros.backend.domain.models.Restaurant;
import com.zeros.backend.domain.repositories.MealRepository;
import com.zeros.backend.domain.repositories.RestaurantRepository;
import com.zeros.backend.domain.services.MealRewarder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SimpleMealRewarderTest {

    private MealRepository mealRepository;

    private MealRewarder mealRewarder;

    @BeforeEach
    void setUp() {
        RestaurantRepository restaurantRepository = mock(RestaurantRepository.class);
        mealRepository = mock(MealRepository.class);
        Restaurant restaurant = new Restaurant("RestaurantSuggestion Opéra");
        when(restaurantRepository.findOne(1L)).thenReturn(restaurant);
        when(restaurantRepository.exists(1L)).thenReturn(true);
        mealRewarder = new SimpleMealRewarder(restaurantRepository, mealRepository);
    }

    @Test
    void should_throw_exception_when_restaurant_does_not_exist() {
        assertThrows(RestaurantNotFoundException.class, () -> mealRewarder.rewardMeal(2L, 1L));
    }

    //TODO @Abdel fix this test to not only chack the meal id
    @Test
    void should_store_meal() throws RestaurantNotFoundException {
        mealRewarder.rewardMeal(1L, 1L);
        Meal savedMeal = new Meal(1L, 1L, LocalDateTime.now());
        verify(mealRepository).save(savedMeal);
    }
}