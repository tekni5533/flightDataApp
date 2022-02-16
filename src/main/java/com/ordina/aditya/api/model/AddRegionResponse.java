package com.ordina.aditya.api.model;

import java.util.Objects;

public class AddRegionResponse {

    String message;
    String regionName;
    RegionData regionData;

    public AddRegionResponse(String message, String regionName, RegionData regionData) {
        this.message = message;
        this.regionName = regionName;
        this.regionData = regionData;
    }

    public String getMessage() {
        return message;
    }

    public String getRegionName() {
        return regionName;
    }

    public RegionData getRegionData() {
        return regionData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddRegionResponse that = (AddRegionResponse) o;
        return message.equals(that.message) &&
                regionName.equals(that.regionName) &&
                regionData.equals(that.regionData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, regionName, regionData);
    }
}
