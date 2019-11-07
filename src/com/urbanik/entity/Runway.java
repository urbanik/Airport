package com.urbanik.entity;

import java.util.ArrayList;
import java.util.List;

public class Runway implements Comparable<Runway> {

    private int id;
    private int length;
    private boolean occupated;
    private List<AirplaneInSystem> history;

    public Runway() {
    }

    public Runway(int id, int length) {
        this.id = id;
        this.length = length;
        this.occupated = false;
        this.history = new ArrayList<>();
    }

    public Runway(int id) {
        this.id = id;
        this.length = 0;
        this.occupated = false;
        this.history = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AirplaneInSystem> getHistory() {
        return history;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isOccupated() {
        return occupated;
    }

    public void setOccupated(boolean occupated) {
        this.occupated = occupated;
    }

    @Override
    public int compareTo(Runway runway) {

        Integer id1 = new Integer(this.getId());
        Integer id2 = new Integer(runway.getId());
        int cmp = id1.compareTo(id2);

        if(cmp < 0){ // AK JE VACSIA HODNOTA

            return 1;

        }else if(cmp == 0){

            return 0;
        } else{ // AK JE MENSIA HODNOTA

            return -1;
        }
    }
}
