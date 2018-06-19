package com.zeros.backend.infrastructure.services;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import com.zeros.backend.domain.services.Location;
import com.zeros.backend.domain.services.Route;
import com.zeros.backend.domain.services.RouteEstimator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;

@Service
public class GoogleRouteEstimator implements RouteEstimator {

    private final GeoApiContext geoApiContext;

    @Autowired
    public GoogleRouteEstimator(final GeoApiContext geoApiContext) {
        this.geoApiContext = geoApiContext;
    }

    @Override
    public Route estimate(Location origin, Location destination, TravelMode travelMode) {
        try {
            DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(geoApiContext)
                    .origins(new LatLng(origin.getLat(), origin.getLng()))
                    .destinations(new LatLng(destination.getLat(), destination.getLng()))
                    .mode(travelMode)
                    .await();

            if (distanceMatrix.rows.length == 0 ||
                    distanceMatrix.rows[0].elements.length == 0)
                throw new RuntimeException("No distance and duration found.");

            BigDecimal distance = new BigDecimal(distanceMatrix.rows[0].elements[0].distance.inMeters);
            Duration duration = Duration.ofSeconds(distanceMatrix.rows[0].elements[0].duration.inSeconds);
            return new Route(distance, duration);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
