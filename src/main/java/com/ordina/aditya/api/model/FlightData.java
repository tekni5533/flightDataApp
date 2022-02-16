package com.ordina.aditya.api.model;

import java.util.Collection;
import java.util.Objects;

public class FlightData {
    private int time;
    private Collection<FlightDataPoint> states;

    public FlightData() {}

    public FlightData(int time, Collection<FlightDataPoint> states) {
        this.time = time;
        this.states = states;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Collection<FlightDataPoint> getStates() {
        return states;
    }

    public void setStates(Collection<FlightDataPoint> states) {
        this.states = states;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightData that = (FlightData) o;
        return time == that.time &&
                states.equals(that.states);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, states);
    }
}
