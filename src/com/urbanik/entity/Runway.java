package com.urbanik.entity;

import com.urbanik.structures.SplayTree;

public class Runway {

    private int id;
    private int length;
    private SplayTree departures;

    public Runway(int id, int length) {
        this.id = id;
        this.length = length;
        departures = new SplayTree();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SplayTree getDepartures() {
        return departures;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
