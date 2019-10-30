package com.urbanik.dto;

import com.urbanik.date.Date;

public class AirplaneDto {

    private String manufacturer;
    private String type;
    private String code;
    private int minDepartureRunwayLength;

    private Date arrivalDate;
    boolean presence;

    private Date runwayDemandDate;
    private boolean waiting;

    private Date departureDate;
    private int priority;

    public AirplaneDto() {
    }

    public AirplaneDto(String code) {
        this.manufacturer = null;
        this.type = null;
        this.code = code;
        this.minDepartureRunwayLength = 0;
        this.priority = 0;
        this.presence = false;
        this.waiting = false;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMinDepartureRunwayLength(int minDepartureRunwayLength) {
        this.minDepartureRunwayLength = minDepartureRunwayLength;
    }

    public String getCode() {
        return code;
    }

    public int getMinDepartureRunwayLength() {
        return minDepartureRunwayLength;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getRunwayDemandDate() {
        return runwayDemandDate;
    }

    public void setRunwayDemandDate(Date runwayDemandDate) {
        this.runwayDemandDate = runwayDemandDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "AirplaneDto{" +
                "manufacturer='" + manufacturer + '\'' +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", minDepartureRunwayLength=" + minDepartureRunwayLength +
                ", arrivalDate=" + arrivalDate +
                ", presence=" + presence +
                ", runwayDemandDate=" + runwayDemandDate +
                ", waiting=" + waiting +
                ", departureDate=" + departureDate +
                ", priority=" + priority +
                '}';
    }
}
