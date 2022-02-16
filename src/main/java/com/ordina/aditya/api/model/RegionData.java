package com.ordina.aditya.api.model;

import java.util.Objects;

public class RegionData {

    Double longitudeMax;
    Double longitudeMin;
    Double latitudeMax;
    Double latitudeMin;

    public RegionData() {
    }

    public RegionData setLongitudeMax(Double longitudeMax) {
        this.longitudeMax = longitudeMax;
        return this;
    }

    public RegionData setLongitudeMin(Double longitudeMin) {
        this.longitudeMin = longitudeMin;
        return this;
    }

    public RegionData setLatitudeMax(Double latitudeMax) {
        this.latitudeMax = latitudeMax;
        return this;
    }

    public RegionData setLatitudeMin(Double latitudeMin) {
        this.latitudeMin = latitudeMin;
        return this;
    }

    public Double getLongitudeMax() {
        return longitudeMax;
    }

    public Double getLongitudeMin() {
        return longitudeMin;
    }

    public Double getLatitudeMax() {
        return latitudeMax;
    }

    public Double getLatitudeMin() {
        return latitudeMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionData that = (RegionData) o;
        return longitudeMax.equals(that.longitudeMax) &&
                longitudeMin.equals(that.longitudeMin) &&
                latitudeMax.equals(that.latitudeMax) &&
                latitudeMin.equals(that.latitudeMin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitudeMax, longitudeMin, latitudeMax, latitudeMin);
    }
}
