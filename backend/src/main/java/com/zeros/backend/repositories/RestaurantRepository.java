package com.zeros.backend.repositories;

import com.zeros.backend.models.Restaurant;

public interface RestaurantRepository extends Repository<Restaurant> {


    Restaurant findByNameAndaddress(String name, String address);

    Boolean exists(String name, String address);

}
