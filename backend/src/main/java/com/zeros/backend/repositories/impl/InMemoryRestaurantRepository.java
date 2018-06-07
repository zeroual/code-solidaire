package com.zeros.backend.repositories.impl;

import com.zeros.backend.models.Restaurant;
import com.zeros.backend.repositories.RestaurantRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRestaurantRepository extends AbstractInMemoryRepository<Restaurant> implements RestaurantRepository {

    public InMemoryRestaurantRepository() {
    }
}
