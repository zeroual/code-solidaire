package com.zeros.backend.api;

import com.zeros.backend.models.Restaurant;
import com.zeros.backend.repositories.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class SubscribtionResourceTest {


    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        restaurantRepository.save(createRestaurant("test","exists"));
    }


    @Test
    void should_return_conflict_status_when_restaurant_already_subscribed() throws Exception {
        mockMvc.perform(post("/api/v1/restaurant/subscribe")
                .content("{\"name\":\"test\",\"address\":\"exists\",\"latitude\":100,\"longitude\":100}")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isConflict());
    }

    @Test
    void should_return_bad_request_status_when_address_is_null() throws Exception {
        mockMvc.perform(post("/api/v1/restaurant/subscribe")
                .content("{\"name\":\"\",\"address\":\"\",\"latitude\":100,\"longitude\":100}")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_return_ok_status_when_restaurant_not_exists() throws Exception {
        mockMvc.perform(post("/api/v1/restaurant/subscribe")
                .content("{\"name\":\"test2\",\"address\":\"not exists\",\"latitude\":100,\"longitude\":100}")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    private Restaurant createRestaurant(String name,String address){
        return new Restaurant(name,address,100d,100d);
    }

}