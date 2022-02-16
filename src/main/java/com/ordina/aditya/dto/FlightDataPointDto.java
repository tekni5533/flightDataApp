package com.ordina.aditya.dto;

import java.time.Instant;

public class FlightDataPointDto {

    private String icao24;
    String callSign;
    Instant dataPointInstant;
    String originCountry;
    boolean onGround;

    public String getCallSign() {
        return callSign;
    }

    public Instant getDataPointInstant() {
        return dataPointInstant;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public FlightDataPointDto setCallSign(String callSign) {
        this.callSign = callSign;
        return this;
    }

    public FlightDataPointDto setDataPointInstant(Instant dataPointInstant) {
        this.dataPointInstant = dataPointInstant;
        return this;
    }

    public FlightDataPointDto setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
        return this;
    }

    public FlightDataPointDto setOnGround(boolean onGround) {
        this.onGround = onGround;
        return this;
    }

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public FlightDataPointDto() {
    }


}
