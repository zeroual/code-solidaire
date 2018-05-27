package com.zeros.backend.service;

import com.google.maps.model.TravelMode;

public interface RouteService {

    public Route estimateRoute(Location userlocation, Location restauranteLocation
    		, TravelMode travelMode);
}
