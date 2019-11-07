package com.urbanik.entity;

import com.urbanik.structures.Node;
import com.urbanik.structures.PairingHeap;
import com.urbanik.structures.SplayTree;

import java.util.ArrayList;
import java.util.List;

public class RunwayGroup implements Comparable<RunwayGroup>{

    private int runwayLength;
    private PairingHeap<AirplaneInSystemByPriority> planesQueue;
    private SplayTree<AirplaneInSystemByCode> waitingPlanesTree;
    private SplayTree<Runway> runwaysTree;
    private List<Runway> runwaysList;
    private List<Node> waitingPlanesNodeList;

    public RunwayGroup() {
        runwayLength = 0;
    }

    public RunwayGroup(int runwayLength) {
        this.runwayLength = runwayLength;
        this.runwaysTree = new SplayTree();
        this.runwaysList = new ArrayList<>();

        this.planesQueue = new PairingHeap();
        this.waitingPlanesTree = new SplayTree();

        waitingPlanesNodeList = new ArrayList<>();
    }

    public int getRunwayLength() {
        return runwayLength;
    }

    public void setRunwayLength(int runwayLength) {
        this.runwayLength = runwayLength;
    }

    public PairingHeap getPlanesQueue() {
        return planesQueue;
    }

    public boolean includesRunway(Runway runway){

        if(runwaysTree.find(runway) != null){
            return true;
        }else{
            return false;
        }
    }

    public SplayTree<Runway> getRunwaysTree() {
        return runwaysTree;
    }

    public SplayTree<AirplaneInSystemByCode> getWaitingPlanesTree() {
        return waitingPlanesTree;
    }

    public List<Runway> getRunwaysList() {
        return runwaysList;
    }

    public void setRunwaysList(List<Runway> runwaysList) {
        this.runwaysList = runwaysList;
    }

    public List<Node> getWaitingPlanesNodeList() {
        return waitingPlanesNodeList;
    }

    public void setWaitingPlanesNodeList(List<Node> waitingPlanesNodeList) {
        this.waitingPlanesNodeList = waitingPlanesNodeList;
    }

    @Override
    public int compareTo(RunwayGroup runwayGroup) {

        Integer length1 = new Integer(this.getRunwayLength());
        Integer length2 = new Integer(runwayGroup.getRunwayLength());
        int cmp = length1.compareTo(length2);

        if(cmp > 0){ // AK JE VACSIA HODNOTA

            return 1;

        }else if(cmp == 0){

            return 0;
        } else{ // AK JE MENSIA HODNOTA

            return -1;
        }
    }
}
