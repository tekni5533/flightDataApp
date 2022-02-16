package com.ordina.aditya.api.model;

import com.ordina.aditya.dto.FlightDataPointDto;

import java.util.List;

public class FlightCallData {
    String callsign;
    List<FlightDataPointDto> flightDataPoint;

    public FlightCallData(String callsign, List<FlightDataPointDto> FlightDataPointDto) {
        this.callsign = callsign;
        this.flightDataPoint = flightDataPoint;
    }


}
