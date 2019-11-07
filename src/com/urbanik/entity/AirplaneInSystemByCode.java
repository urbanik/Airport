package com.urbanik.entity;

public class AirplaneInSystemByCode implements Comparable<AirplaneInSystemByCode> {

    private AirplaneInSystem airplaneInSystem;

    public AirplaneInSystemByCode() {
        this.airplaneInSystem = null;
    }

    public AirplaneInSystemByCode(AirplaneInSystem airplaneInSystem) {
        this.airplaneInSystem = airplaneInSystem;
    }

    public void setAirplaneInSystem(AirplaneInSystem airplaneInSystem) {
        this.airplaneInSystem = airplaneInSystem;
    }

    public AirplaneInSystem getAirplaneInSystem() {
        return airplaneInSystem;
    }

    @Override
    public int compareTo(AirplaneInSystemByCode o) {
        int cmp = this.getAirplaneInSystem().getAirplane().getCode().compareTo(o.getAirplaneInSystem().getAirplane().getCode());

        if(cmp > 0){ // AK JE VACSIA HODNOTA, TEDA NIZSIA PRIORITA

            return -1;

        }else if(cmp == 0){

            return 0;
        } else{ // AK JE MENSIA HODNOTA, TEDA VYSSIA PRIORITA

            return 1;
        }
    }

    @Override
    public String toString() {
        return "AirplaneByCode{" +
                "airplane=" + airplaneInSystem +
                '}';
    }
}
