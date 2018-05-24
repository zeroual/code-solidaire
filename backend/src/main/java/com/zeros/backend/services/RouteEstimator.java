package com.zeros.backend.services;

import com.google.maps.model.TravelMode;
import com.zeros.backend.models.Location;

public interface RouteEstimator {

    Route estimate(Location origin, Location destination, TravelMode travelMode);
}
