package com.zeros.backend;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RestaurantService {

    public List<Restaurant> getNearbyRestaurant() throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyBvLjHOMjmRVWELPcxI-YJ43rGJk2-cw2w")
                .build();
        LatLng OperaParis = new LatLng(48.874037, 2.339619);
        PlacesSearchResponse searchResponse = PlacesApi.nearbySearchQuery(context, OperaParis)
                .radius(200)
                .type(PlaceType.RESTAURANT)
                .await();
        return Stream.of(searchResponse.results).limit(10)
                .map(s -> {
                    List<String> photosReference = Stream.of(s.photos).map(photo -> photo.photoReference).collect(Collectors.toList());
                    return new Restaurant(s.name,
                            new Location(s.geometry.location.lat, s.geometry.location.lng),
                            s.vicinity, Arrays.asList(s.photos[0].photoReference), s.rating);
                })
                .collect(Collectors.toList());
    }
}
