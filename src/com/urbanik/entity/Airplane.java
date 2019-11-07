package com.urbanik.entity;

import com.urbanik.date.Date;

public class Airplane {

    private String manufacturer;
    private String type;
    private String code;
    private int minDepartureRunwayLength;
    private int systemDepartureLength;
    private int priority;


    public Airplane() {
        this.manufacturer = null;
        this.type = null;
        this.code = null;
        this.minDepartureRunwayLength = 0;
        priority = 0;
    }

    public Airplane(String manufacturer, String type, String code, int minDepartureRunwayLength, int priority) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.code = code;
        this.minDepartureRunwayLength = minDepartureRunwayLength;
        this.priority = priority;
        setSystemDepartureLength();
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

    public int getSystemDepartureLength() {
        return systemDepartureLength;
    }

    public void setSystemDepartureLength() {

        if(this.minDepartureRunwayLength <= 1500){
            this.systemDepartureLength = 1500;
            return;
        }else if(this.minDepartureRunwayLength <= 2000){
            this.systemDepartureLength = 2000;
            return;
        }else if(this.minDepartureRunwayLength <= 2500){
            this.systemDepartureLength = 2500;
            return;
        }else if(this.minDepartureRunwayLength <= 3000){
            this.systemDepartureLength = 3000;
            return;
        }else{
            this.systemDepartureLength = 3500;
            return;
        }

    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
