package com.zeros.backend.services;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.zeros.backend.models.Location;
import com.zeros.backend.models.Restaurant;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RestaurantService {

    public List<Restaurant> getNearbyRestaurant() throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyBvLjHOMjmRVWELPcxI-YJ43rGJk2-cw2w")
                .build();
        LatLng searchLocation = new LatLng(48.874037, 2.339619);
        PlacesSearchResponse searchResponse = PlacesApi.nearbySearchQuery(context, searchLocation)
                .radius(200)
                .type(PlaceType.RESTAURANT)
                .await();
//        Stream.of(searchResponse.results).limit(1)
//                .forEach(r -> System.out.println(">>>>>>>>>>>>>>" + Arrays.toString(r.types)));
        return Stream.of(searchResponse.results).limit(5)
                .map(s -> new Restaurant(s.name,
                        new Location(s.geometry.location.lat, s.geometry.location.lng), s.formattedAddress))
                .collect(Collectors.toList());
    }
}
