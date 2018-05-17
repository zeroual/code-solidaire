package com.zeros.backend;

import com.google.maps.errors.ApiException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void souldReturnAtLeastOneRestaurant() throws InterruptedException, ApiException, IOException {
        Assert.assertNotNull(restaurantService.getNearbyRestaurant());
        Assert.assertTrue( restaurantService.getNearbyRestaurant().size() > 0 );
    }

}