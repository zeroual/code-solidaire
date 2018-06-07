package com.zeros.backend.api;

import com.zeros.backend.models.Restaurant;
import com.zeros.backend.repositories.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class RewardResourceTest {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_return_not_found_status_when_restaurant_does_not_exist() throws Exception {
        mockMvc.perform(post("/api/v1/reward")
                .content("{\"restaurantId\":999}")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    void should_return_ok_status_when_restaurant_exists() throws Exception {
        Restaurant restaurant = new Restaurant("RestaurantSuggestion Opéra");
        Restaurant storedRestaurant = restaurantRepository.save(restaurant);

        mockMvc.perform(post("/api/v1/reward")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\"restaurantId\":" + storedRestaurant.getId() + "}"))
                .andExpect(status().isOk());
    }

}