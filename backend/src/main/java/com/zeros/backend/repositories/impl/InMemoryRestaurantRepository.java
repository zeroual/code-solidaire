package com.zeros.backend.repositories.impl;

import com.zeros.backend.models.Restaurant;
import com.zeros.backend.repositories.RestaurantRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.StreamSupport;

@Repository
public class InMemoryRestaurantRepository extends AbstractInMemoryRepository<Restaurant> implements RestaurantRepository {

    public InMemoryRestaurantRepository() {
    }

    public Restaurant findByNameAndaddress(String name, String address) {
        return StreamSupport
                .stream(findAll()
                        .spliterator(), false)
                .filter(r -> r.getName().equals(name) && r.getaddress().equals(address))
                .findFirst().orElse(null);
    }

    @Override
    public Boolean exists(String name, String address) {
        return findByNameAndaddress(name,address) != null;
    }
}
