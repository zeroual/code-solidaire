package com.zeros.backend.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.TravelMode;

@Service
public class RestaurantService {

    private final GeoApiContext geoApiContext;
    private final RouteEstimator routeService;

    @Autowired
    public RestaurantService(GeoApiContext geoApiContext, RouteEstimator routeestimator) {
        this.geoApiContext = geoApiContext;
        this.routeService= routeestimator;
    }

    public List<Restaurant> getNearbyRestaurant() {
    	Location userLocation = new Location(48.874037, 2.339619);
        try {
            PlacesSearchResponse searchResponse = PlacesApi.nearbySearchQuery(geoApiContext, 
            		new LatLng(userLocation.getLat(), userLocation.getLng()))
                    .radius(1000)
                    .type(PlaceType.RESTAURANT)
                    .await();
            return Stream.of(searchResponse.results).limit(5)
                    .map(searchResult -> {
                        List<String> photos = Stream.of(searchResult.photos).map(photo -> photo.photoReference).collect(toList());
                        Location restaurantLocation = new Location(searchResult.geometry.location.lat, searchResult.geometry.location.lng);
                        Route route = routeService.estimate(userLocation, restaurantLocation, TravelMode.WALKING);
                        return new Restaurant(searchResult.name, restaurantLocation, searchResult.rating, photos, route);
                    })
                    .collect(toList());
        } catch (Exception e) {
            throw new RuntimeException("Ooops! we cant get places from google maps service", e);
        }
    }
}
