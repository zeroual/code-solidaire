package com.zeros.backend.domain.services;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Objects;

public class Route {

    private final BigDecimal distance;
    private final Duration duration;

    public Route(BigDecimal distance, Duration duration) {
        this.distance = distance;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Route)) {
            return false;
        }
        Route route = (Route) o;
        return Objects.equals(distance, route.distance) &&
                Objects.equals(duration, route.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, duration);
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
    }
}