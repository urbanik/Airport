package com.urbanik.dto;

import com.urbanik.date.Date;

public class AirplaneDto {

    private String manufacturer;
    private String type;
    private String code;
    private int minDepartureRunwayLength;
    private int priority;

    public AirplaneDto() {
    }

    public AirplaneDto(String code) {
        this.manufacturer = null;
        this.type = null;
        this.code = code;
        this.minDepartureRunwayLength = 0;
    }

    public AirplaneDto(String manufacturer, String type, String code, int minDepartureRunwayLength, int priority) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.code = code;
        this.minDepartureRunwayLength = minDepartureRunwayLength;
        this.priority = priority;
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



    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "Airplane { " +
                "manufacturer = " + manufacturer +
                ", type = " + type +
                ", code = " + code +
                ", min departure length = " + minDepartureRunwayLength +
                ", priority = " + priority +
                "}";
    }
}
