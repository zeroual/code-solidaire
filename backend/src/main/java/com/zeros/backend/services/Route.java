package com.zeros.backend.services;

import java.math.BigDecimal;

public class Route {

    private final BigDecimal distance; private final BigDecimal duration;
   	public Route(BigDecimal distance, BigDecimal duration) {
    		this.distance = distance;
    		this.duration = duration;
    	}
    	public BigDecimal getDistance() {
    	 return distance;
    	}
    	public BigDecimal getDuration() {
    		return duration;
    	}
}