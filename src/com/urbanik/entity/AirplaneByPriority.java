package com.urbanik.entity;

public class AirplaneByPriority implements Comparable<AirplaneByPriority> {

    private Airplane airplane;

    public AirplaneByPriority(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    @Override
    public int compareTo(AirplaneByPriority o) {

        Integer priority1 = new Integer(this.getAirplane().getPriority());
        Integer priority2 = new Integer(o.getAirplane().getPriority());
        int cmp = priority1.compareTo(priority2);

        if(cmp >= 0){ // AK JE VACSIA HODNOTA, TEDA NIZSIA PRIORITA

            return 1;

        }else{ // AK JE MENSIA HODNOTA, TEDA VYSSIA PRIORITA

            return -1;
        }
    }

    @Override
    public String toString() {
        return "AirplaneByPriority{" +
                "airplane=" + airplane +
                '}';
    }
}
