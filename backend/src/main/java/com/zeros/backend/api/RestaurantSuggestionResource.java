package com.zeros.backend.api;

import com.zeros.backend.models.Restaurant;
import com.zeros.backend.services.RestaurantRecommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestaurantSuggestionResource {

    @Autowired
    private RestaurantRecommender restaurantRecommender;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantRecommender.getNearbyRestaurant();
    }
}
