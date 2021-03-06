package com.zeros.backend.api;

import com.zeros.backend.domain.services.RestaurantSuggester;
import com.zeros.backend.domain.services.RestaurantSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestaurantSuggestionResource {

    @Autowired
    private RestaurantSuggester restaurantSuggester;

    @GetMapping("/restaurants")
    public List<RestaurantSuggestion> getRestaurants(@RequestParam(value = "latitude") double latitude
            , @RequestParam(value = "longitude") double longitude) {
        return restaurantSuggester.getNearbyRestaurant(latitude, longitude);
    }
}
