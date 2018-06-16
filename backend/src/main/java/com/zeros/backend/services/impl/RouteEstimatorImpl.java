package com.zeros.backend.services.impl;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import com.zeros.backend.services.Location;
import com.zeros.backend.services.Route;
import com.zeros.backend.services.RouteEstimator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;

@Service
public class RouteEstimatorImpl implements RouteEstimator {

    private final GeoApiContext geoApiContext;

    @Autowired
    public RouteEstimatorImpl(final GeoApiContext geoApiContext) {
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

            return new Route(new BigDecimal(distanceMatrix.rows[0].elements[0].distance.inMeters),
                    		new BigDecimal(distanceMatrix.rows[0].elements[0].duration.inSeconds));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
