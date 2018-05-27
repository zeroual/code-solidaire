package com.zeros.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeros.backend.service.Restaurante;
import com.zeros.backend.service.RestauranteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestauranteResource {

    @Autowired
    private RestauranteService restaurantRecommender;

    @GetMapping("/restaurants")
    public List<Restaurante> getRestaurants() {
        return restaurantRecommender.getNearbyRestaurant();
    }
}
