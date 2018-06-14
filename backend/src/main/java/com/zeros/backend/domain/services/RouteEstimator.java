package com.zeros.backend.domain.services;

import com.google.maps.model.TravelMode;

public interface RouteEstimator {

    Route estimate(Location origin, Location destination, TravelMode travelMode);
}
