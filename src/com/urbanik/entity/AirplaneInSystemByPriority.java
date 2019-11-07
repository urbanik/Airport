package com.urbanik.entity;

public class AirplaneInSystemByPriority implements Comparable<AirplaneInSystemByPriority> {

    private AirplaneInSystem airplaneInSystem;

    public AirplaneInSystemByPriority(AirplaneInSystem airplaneInSystem) {
        this.airplaneInSystem = airplaneInSystem;
    }

    public AirplaneInSystem getAirplaneInSystem() {
        return airplaneInSystem;
    }

    @Override
    public int compareTo(AirplaneInSystemByPriority o) {

        Integer priority1 = new Integer(this.getAirplaneInSystem().getAirplane().getPriority());
        Integer priority2 = new Integer(o.getAirplaneInSystem().getAirplane().getPriority());
        int cmp = priority1.compareTo(priority2);

        if(cmp < 0){ // AK JE VACSIA HODNOTA, TEDA NIZSIA PRIORITA

            return 1;

        }else if(cmp > 0){ // AK JE MENSIA HODNOTA, TEDA VYSSIA PRIORITA

            return -1;

        } else {

            int cmpd = this.getAirplaneInSystem().getRunwayDemandDate().compareTo(o.getAirplaneInSystem().getRunwayDemandDate());
            if(cmpd > 0){

                return 1;

            }else{

                return 2;

            }
        }
    }

    @Override
    public String toString() {
        return "AirplaneByPriority{" +
                "airplane=" + airplaneInSystem +
                '}';
    }
}
