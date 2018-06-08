package com.zeros.backend;

import com.zeros.backend.models.Restaurant;
import com.zeros.backend.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }



    //TODO remove this populater when migarting to DBM
    @Component
    static class DatabasePopulater implements CommandLineRunner {

        @Autowired
        private RestaurantRepository restaurantRepository;

        @Override
        public void run(String... args) throws Exception {
            Restaurant restaurant = new Restaurant("RestaurantSuggestion Opéra");
            restaurantRepository.save(restaurant);
        }
    }
}
