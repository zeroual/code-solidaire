package com.zeros.backend.domain.services.impl;

import com.zeros.backend.domain.exceptions.AlreadySubscribedRestaurantException;
import com.zeros.backend.domain.models.Restaurant;
import com.zeros.backend.domain.repositories.RestaurantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RestaurantSubscribtionTest {


    private SimpleRestaurantSubscriber simpleRestaurantSubscriber;
    private RestaurantRepository restaurantRepository;


    @BeforeEach
    public void setUp() {
        restaurantRepository = Mockito.mock(RestaurantRepository.class);
        simpleRestaurantSubscriber = new SimpleRestaurantSubscriber(restaurantRepository);
        restaurantRepository = Mockito.mock(RestaurantRepository.class);
        simpleRestaurantSubscriber = new SimpleRestaurantSubscriber(restaurantRepository);
        Mockito.when(restaurantRepository.exists("test", "exists")).thenReturn(true);
        Mockito.when(restaurantRepository.exists("test 3", "not exists")).thenReturn(false);
    }

    private Restaurant createRestaurant(String name, String address) {
        return new Restaurant(name, address, 100d, 100d);
    }

    @Test
    public void subscribe_should_not_save_existing_restaurant() {
        Assertions.assertThrows(AlreadySubscribedRestaurantException.class, () -> simpleRestaurantSubscriber.subscribe(createRestaurant("test", "exists")));
    }

    @Test
    public void subscribe_should_not_save_illegal_arguments_restaurant() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> simpleRestaurantSubscriber.subscribe(new Restaurant("Test Illegal Args")));
    }

    @Test
    public void subscribe_should_save_not_existing_restaurant() {
        Restaurant restaurant = createRestaurant("test 3", "not exists");
        simpleRestaurantSubscriber.subscribe(restaurant);
        Mockito.verify(restaurantRepository, Mockito.times(1)).save(restaurant);
    }

}
