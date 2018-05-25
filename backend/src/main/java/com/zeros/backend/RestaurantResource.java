package com.zeros.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestaurantResource {

    @Autowired
    private RestaurantRecommender restaurantRecommender;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantRecommender.getNearbyRestaurant();
    }
}
