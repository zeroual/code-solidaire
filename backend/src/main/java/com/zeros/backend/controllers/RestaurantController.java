package com.zeros.backend.controllers;

import com.google.maps.errors.ApiException;
import com.zeros.backend.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("restaurants")
    public List getRestaurants() throws InterruptedException, ApiException, IOException {
        return restaurantService.getNearbyRestaurant();
    }
}
