package com.zeros.backend.service;

import java.math.BigDecimal;
import java.time.Duration;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.maps.model.TravelMode;
import com.zeros.backend.BackendApplication;

@SpringBootTest(classes = BackendApplication.class)
@ActiveProfiles("ut")
@RunWith(SpringRunner.class)
public class RouteServiceImplTest {

	@Autowired
	private RouteService routeService;
    
    @Test
    public void estimateRoute_should_return_distance_and_duration(){
    	Route expected = new Route.newBuilder().distance(new BigDecimal(1880))
    			.duration(Duration.ofSeconds(1685)).build();
    	 
    	Route actual =routeService.estimateRoute(new Location(48.874037, 2.339619), new Location(48.8867, 2.3431)
    			, TravelMode.WALKING);
    	
		Assertions.assertThat(actual).isEqualTo(expected);
    }
}
