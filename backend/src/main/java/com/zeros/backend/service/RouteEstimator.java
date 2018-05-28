package com.zeros.backend.service;

import com.google.maps.model.TravelMode;

public interface RouteEstimator {

    Route estimate(Location origin, Location destination, TravelMode travelMode);
}
