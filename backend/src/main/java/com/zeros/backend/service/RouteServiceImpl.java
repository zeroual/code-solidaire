package com.zeros.backend.service;

import java.math.BigDecimal;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;

@Service
public class RouteServiceImpl implements RouteService{

	private final GeoApiContext geoApiContext;

	@Autowired
	public RouteServiceImpl(final GeoApiContext geoApiContext) {
		this.geoApiContext = geoApiContext;
	}

	@Override
	public Route estimateRoute(Location userlocation, Location restauranteLocation
			, TravelMode travelMode) {
		try {
			DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest( geoApiContext )
					.origins(userlocation.toLatLng())
					.destinations(restauranteLocation.toLatLng())
					.mode(travelMode)
					.await();

			if( distanceMatrix.rows.length == 0 ||
					distanceMatrix.rows[0].elements.length == 0 )
				throw new RuntimeException("No distance and duration found.");

			return new Route.newBuilder().distance(new BigDecimal(distanceMatrix.rows[0].elements[0].distance.inMeters))
					.duration(Duration.ofSeconds(distanceMatrix.rows[0].elements[0].duration.inSeconds)).build();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
