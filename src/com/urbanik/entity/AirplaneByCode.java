package com.urbanik.entity;

public class AirplaneByCode implements Comparable<AirplaneByCode> {

    private Airplane airplane;

    public AirplaneByCode() {
        this.airplane = null;
    }

    public AirplaneByCode(Airplane airplane) {
        this.airplane = airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    @Override
    public int compareTo(AirplaneByCode o) {
        int cmp = this.getAirplane().getCode().compareTo(o.getAirplane().getCode());

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
                "airplane=" + airplane +
                '}';
    }
}
