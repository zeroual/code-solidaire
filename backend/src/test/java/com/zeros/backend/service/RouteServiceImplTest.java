package com.zeros.backend.service;

import com.google.maps.model.TravelMode;
import com.zeros.backend.BackendApplication;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = BackendApplication.class)
@ActiveProfiles("ut")
@RunWith(SpringRunner.class)
public class RouteServiceImplTest {

    @Autowired
    private RouteEstimator routeService;

    @Test
    public void estimateRoute_should_return_distance_and_duration() {

        Route actual = routeService.estimate(new Location(48.874037, 2.339619), new Location(48.8867, 2.3431)
                , TravelMode.WALKING);

        Assertions.assertThat(actual).isNotNull();
    }
}
