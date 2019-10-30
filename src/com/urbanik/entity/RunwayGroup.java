package com.urbanik.entity;

import com.urbanik.structures.PairingHeap;
import com.urbanik.structures.SplayTree;

import java.util.ArrayList;
import java.util.List;

public class RunwayGroup implements Comparable<RunwayGroup> {

    private int runwayLength;
    private PairingHeap waitingPlanes;
    private List<Runway> runways;

    public RunwayGroup(int runwayLength) {
        this.runwayLength = runwayLength;
        this.runways = new ArrayList();
        waitingPlanes = new PairingHeap();
    }

    public int getRunwayLength() {
        return runwayLength;
    }

    public void setRunwayLength(int runwayLength) {
        this.runwayLength = runwayLength;
    }

    public PairingHeap getWaitingPlanes() {
        return waitingPlanes;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    @Override
    public int compareTo(RunwayGroup o) {
        return 0;
    }
}
