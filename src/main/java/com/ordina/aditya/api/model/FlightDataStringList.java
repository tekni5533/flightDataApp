package com.ordina.aditya.api.model;

import java.util.Collection;
import java.util.List;

public class FlightDataStringList {
    private List<Object> flightDataPoints;

    public List<Object> getFlightDataPoints() {
        return flightDataPoints;
    }

    public void setFlightDataPoints(List<Object> flightDataPoints) {
        this.flightDataPoints = flightDataPoints;
    }

    public FlightDataStringList(List<Object> flightDataPoints) {
        this.flightDataPoints = flightDataPoints;
    }
}
