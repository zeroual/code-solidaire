package com.zeros.backend.services.impl;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.TravelMode;
import com.zeros.backend.services.Location;
import com.zeros.backend.services.RestaurantSuggester;
import com.zeros.backend.services.RestaurantSuggestion;
import com.zeros.backend.services.Route;
import com.zeros.backend.services.RouteEstimator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class GoogleRestaurantSuggester implements RestaurantSuggester {

    private final GeoApiContext geoApiContext;
    private final RouteEstimator routeService;

    @Autowired
    public GoogleRestaurantSuggester(GeoApiContext geoApiContext, RouteEstimator routeestimator) {
        this.geoApiContext = geoApiContext;
        this.routeService= routeestimator;
    }

    public List<RestaurantSuggestion> getNearbyRestaurant() {
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
                        return new RestaurantSuggestion(searchResult.name, restaurantLocation, searchResult.rating, photos, route);
                    })
                    .collect(toList());
        } catch (Exception e) {
            throw new RuntimeException("Ooops! we cant get places from google maps service", e);
        }
    }
}
