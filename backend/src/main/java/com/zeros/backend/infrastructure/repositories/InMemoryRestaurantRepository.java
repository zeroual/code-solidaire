package com.zeros.backend.infrastructure.repositories;

import com.zeros.backend.domain.models.Restaurant;
import com.zeros.backend.domain.repositories.RestaurantRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.StreamSupport;

@Repository
public class InMemoryRestaurantRepository extends AbstractInMemoryRepository<Restaurant> implements RestaurantRepository {

    public InMemoryRestaurantRepository() {
    }

    public Restaurant findByNameAndAddress(String name, String address) {
        return StreamSupport
                .stream(findAll()
                        .spliterator(), false)
                .filter(r -> r.getName().equals(name) && r.getaddress().equals(address))
                .findFirst().orElse(null);
    }

    @Override
    public Boolean exists(String name, String address) {
        return findByNameAndAddress(name, address) != null;
    }
}
