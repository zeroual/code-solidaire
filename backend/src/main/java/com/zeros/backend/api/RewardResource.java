package com.zeros.backend.api;

import com.zeros.backend.exceptions.RestaurantNotFoundException;
import com.zeros.backend.services.MealRewarder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RewardResource {

    @Autowired
    private MealRewarder mealRewarder;

    @PostMapping(value = "/reward")
    public void rewardMeal(@RequestBody RestaurantIdentifier restaurantIdentifier) throws RestaurantNotFoundException {
        mealRewarder.rewardMeal(restaurantIdentifier.getRestaurantId(), 1L);
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleResourceDoesNotExistException() {
    }

    static class RestaurantIdentifier {

        private Long restaurantId;

        private RestaurantIdentifier() {
        }

        public Long getRestaurantId() {
            return restaurantId;
        }
    }
}
