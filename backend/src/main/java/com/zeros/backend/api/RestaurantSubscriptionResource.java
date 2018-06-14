package com.zeros.backend.api;

import com.zeros.backend.exceptions.AlreadySubscribedRestaurantException;
import com.zeros.backend.models.Restaurant;
import com.zeros.backend.services.RestaurantSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RestaurantSubscriptionResource {

    @Autowired
    private RestaurantSubscriber restaurantSubscriber;

    @PostMapping("/restaurant/subscribe")
    public void subscribe(@RequestBody RestaurantSubscriptionRequest restaurantSubscriptionRequest) {
        restaurantSubscriber.subscribe(restaurantSubscriptionRequest.toDomain());
    }

    @ExceptionHandler(AlreadySubscribedRestaurantException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleResourceAlreadyExistException() {

    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadRequestException() {
    }


    static class RestaurantSubscriptionRequest {

        private String name;
        private String address;
        private Double latitude;
        private Double longitude;

        public RestaurantSubscriptionRequest() {

        }

        public String getName() {
            return name;
        }

        public String getaddress() {
            return address;
        }

        public Double getLatitude() {
            return latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public Restaurant toDomain(){
            return new Restaurant(name,address,latitude,longitude);
        }
    }
}
