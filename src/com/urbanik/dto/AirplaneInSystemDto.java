package com.urbanik.dto;

import com.urbanik.date.Date;

public class AirplaneInSystemDto {

    private String manufacturer;
    private String type;
    private String code;
    private int minDepartureRunwayLength;
    private int systemDepartureLength;
    private int departureRunwayId;

    private Date arrivalDate;
    boolean presence;

    private Date runwayDemandDate;
    private boolean waiting;

    private Date departureDate;
    private int priority;

    public AirplaneInSystemDto() {
    }

    public AirplaneInSystemDto(String code) {
        this.manufacturer = null;
        this.type = null;
        this.code = code;
        this.minDepartureRunwayLength = 0;
        systemDepartureLength = 0;
        this.priority = 0;
        this.presence = false;
        this.waiting = false;
        this.departureRunwayId = -1;
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

    public int getSystemDepartureLength() {
        return systemDepartureLength;
    }

    public void setSystemDepartureLength(int systemDepartureLength) {
        this.systemDepartureLength = systemDepartureLength;
    }

    public int getDepartureRunwayId() {
        return departureRunwayId;
    }

    public void setDepartureRunwayId(int departureRunwayId) {
        this.departureRunwayId = departureRunwayId;
    }

    @Override
    public String toString() {
        return "Airplane { " +
                "manufacturer = " + manufacturer +
                ", type = " + type +
                ", code = " + code +
                ", min departure length = " + minDepartureRunwayLength +
                ", arrival = " + arrivalDate +
                ", presence = " + presence +
                ", demand runway = " + runwayDemandDate +
                ", on runway = " + departureRunwayId +
                ", waiting = " + waiting +
                ", departure = " + departureDate +
                ", priority = " + priority +
                "}";
    }
}
