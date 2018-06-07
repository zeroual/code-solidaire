package com.zeros.backend.services;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Objects;

public class Route {

    private final BigDecimal distance;
    private final Duration duration;

    private Route(newBuilder builder) {
        this.distance = builder.distance;
        this.duration = builder.duration;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
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

    public static class newBuilder {
        private BigDecimal distance;
        private Duration duration;

        public newBuilder() {
        }

        public newBuilder distance(BigDecimal distance) {
            this.distance = distance;
            return this;
        }


        public newBuilder duration(Duration duration) {
            this.duration = duration;
            return this;
        }


        public Route build() {
            return new Route(this);
        }
    }
}