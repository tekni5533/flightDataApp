package com.ordina.aditya.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Objects;
import java.util.Set;

@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class FlightDataPoint {

    private String icao24; //0 "4b1815"
    private String callsign;//1 "SWR78J  "
    private String originCountry;//2 "Switzerland"
    private Double lastPositionUpdate;//3 1644520982
    private Double lastContact;//4 1644520982
    private Double longitude;//5 4.9129
    private Double latitude;//6 50.6589
    private Double geoAltitude;//7 5615.94
    private boolean onGround;//8 false
    private Double velocity;//9 197.63
    private Double heading;//10 121.37
    private Double verticalRate;//11 17.23
    private Set<Integer> sensors;//12 null
    private Double baroAltitude;//13 5585.46
    private String squawk;//14 "1000"
    private boolean spi;//15 false
    private PositionSource positionSource;//16 0
    private int unknownProp;//17 0

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public void setLastPositionUpdate(Double lastPositionUpdate) {
        this.lastPositionUpdate = lastPositionUpdate;
    }

    public void setLastContact(Double lastContact) {
        this.lastContact = lastContact;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setGeoAltitude(Double geoAltitude) {
        this.geoAltitude = geoAltitude;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public void setVelocity(Double velocity) {
        this.velocity = velocity;
    }

    public void setHeading(Double heading) {
        this.heading = heading;
    }

    public void setVerticalRate(Double verticalRate) {
        this.verticalRate = verticalRate;
    }

    public void setSensors(Set<Integer> sensors) {
        this.sensors = sensors;
    }

    public void setBaroAltitude(Double baroAltitude) {
        this.baroAltitude = baroAltitude;
    }

    public void setSquawk(String squawk) {
        this.squawk = squawk;
    }

    public void setSpi(boolean spi) {
        this.spi = spi;
    }

    public void setPositionSource(PositionSource positionSource) {
        this.positionSource = positionSource;
    }

    public void setUnknownProp(int unknownProp) {
        this.unknownProp = unknownProp;
    }

    public FlightDataPoint() {
    }

    public String getIcao24() {
        return icao24;
    }

    public String getCallsign() {
        return callsign;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public Double getLastPositionUpdate() {
        return lastPositionUpdate;
    }

    public Double getLastContact() {
        return lastContact;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getGeoAltitude() {
        return geoAltitude;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public Double getVelocity() {
        return velocity;
    }

    public Double getHeading() {
        return heading;
    }

    public Double getVerticalRate() {
        return verticalRate;
    }

    public Set<Integer> getSensors() {
        return sensors;
    }

    public Double getBaroAltitude() {
        return baroAltitude;
    }

    public String getSquawk() {
        return squawk;
    }

    public boolean isSpi() {
        return spi;
    }

    public PositionSource getPositionSource() {
        return positionSource;
    }

    public int getUnknownProp() {
        return unknownProp;
    }

    public FlightDataPoint(String icao24, String callsign, String originCountry, Double lastPositionUpdate, Double lastContact, Double longitude, Double latitude, Double geoAltitude, boolean onGround, Double velocity, Double heading, Double verticalRate, Set<Integer> sensors, Double baroAltitude, String squawk, boolean spi, PositionSource positionSource, int unknownProp) {
        this.icao24 = icao24;
        this.callsign = callsign;
        this.originCountry = originCountry;
        this.lastPositionUpdate = lastPositionUpdate;
        this.lastContact = lastContact;
        this.longitude = longitude;
        this.latitude = latitude;
        this.geoAltitude = geoAltitude;
        this.onGround = onGround;
        this.velocity = velocity;
        this.heading = heading;
        this.verticalRate = verticalRate;
        this.sensors = sensors;
        this.baroAltitude = baroAltitude;
        this.squawk = squawk;
        this.spi = spi;
        this.positionSource = positionSource;
        this.unknownProp = unknownProp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDataPoint that = (FlightDataPoint) o;
        return onGround == that.onGround &&
                spi == that.spi &&
                unknownProp == that.unknownProp &&
                icao24.equals(that.icao24) &&
                Objects.equals(callsign, that.callsign) &&
                Objects.equals(originCountry, that.originCountry) &&
                Objects.equals(lastPositionUpdate, that.lastPositionUpdate) &&
                Objects.equals(lastContact, that.lastContact) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(geoAltitude, that.geoAltitude) &&
                Objects.equals(velocity, that.velocity) &&
                Objects.equals(heading, that.heading) &&
                Objects.equals(verticalRate, that.verticalRate) &&
                Objects.equals(sensors, that.sensors) &&
                Objects.equals(baroAltitude, that.baroAltitude) &&
                Objects.equals(squawk, that.squawk) &&
                positionSource == that.positionSource;
    }

    @Override
    public int hashCode() {
        return Objects.hash(icao24, callsign, originCountry, lastPositionUpdate, lastContact, longitude, latitude, geoAltitude, onGround, velocity, heading, verticalRate, sensors, baroAltitude, squawk, spi, positionSource, unknownProp);
    }
}
