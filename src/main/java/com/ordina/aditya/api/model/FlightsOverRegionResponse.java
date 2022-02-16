package com.ordina.aditya.api.model;

import java.util.Objects;

public class FlightsOverRegionResponse {
    int flightCount;
    RegionData regionData;
    String regionName;

    public FlightsOverRegionResponse() {
    }

    public FlightsOverRegionResponse(int flightCount, RegionData regionData, String regionName) {
        this.flightCount = flightCount;
        this.regionData = regionData;
        this.regionName = regionName;
    }

    public int getFlightCount() {
        return flightCount;
    }

    public RegionData getRegionData() {
        return regionData;
    }

    public String getRegionName() {
        return regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightsOverRegionResponse that = (FlightsOverRegionResponse) o;
        return flightCount == that.flightCount &&
                regionData.equals(that.regionData) &&
                regionName.equals(that.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightCount, regionData, regionName);
    }
}
