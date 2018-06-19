package com.zeros.backend.domain.repositories;

import com.zeros.backend.domain.models.Restaurant;

public interface RestaurantRepository extends Repository<Restaurant> {


    Restaurant findByNameAndAddress(String name, String address);

    Boolean exists(String name, String address);

}
