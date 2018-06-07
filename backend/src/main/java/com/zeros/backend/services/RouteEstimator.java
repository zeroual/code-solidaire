package com.zeros.backend.services;

import com.google.maps.model.TravelMode;

public interface RouteEstimator {

    Route estimate(Location origin, Location destination, TravelMode travelMode);
}
