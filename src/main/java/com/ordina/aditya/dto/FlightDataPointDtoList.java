package com.ordina.aditya.dto;

import com.ordina.aditya.api.model.FlightDataPoint;

import java.time.Instant;
import java.util.ArrayList;

public class FlightDataPointDtoList extends ArrayList<FlightDataPointDto> {

    public void add(int time, FlightDataPoint flightDataPoint) {
        super.add(new FlightDataPointDto()
                .setCallSign(flightDataPoint.getCallsign())
                .setDataPointInstant(Instant.ofEpochMilli(time))
                .setOnGround(flightDataPoint.isOnGround())
                .setOriginCountry(flightDataPoint.getOriginCountry())
        );
    }
}
