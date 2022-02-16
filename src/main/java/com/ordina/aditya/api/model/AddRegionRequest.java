package com.ordina.aditya.api.model;

public class AddRegionRequest {
    String regionName;
    Double longitudeMax;
    Double latitudeMax;
    Double longitudeMin;
    Double latitudeMin;

    public AddRegionRequest() {
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Double getLongitudeMax() {
        return longitudeMax;
    }

    public void setLongitudeMax(Double longitudeMax) {
        this.longitudeMax = longitudeMax;
    }

    public Double getLatitudeMax() {
        return latitudeMax;
    }

    public void setLatitudeMax(Double latitudeMax) {
        this.latitudeMax = latitudeMax;
    }

    public Double getLongitudeMin() {
        return longitudeMin;
    }

    public void setLongitudeMin(Double longitudeMin) {
        this.longitudeMin = longitudeMin;
    }

    public Double getLatitudeMin() {
        return latitudeMin;
    }

    public void setLatitudeMin(Double latitudeMin) {
        this.latitudeMin = latitudeMin;
    }
}
