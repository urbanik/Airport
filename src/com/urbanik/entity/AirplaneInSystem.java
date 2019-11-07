package com.urbanik.entity;

import com.urbanik.date.Date;
import com.urbanik.structures.Node;

public class AirplaneInSystem {

    private Date arrivalDate;
    boolean presence;

    private Date runwayDemandDate;
    private boolean waiting;
    private int departureRunwayId;

    private Date departureDate;
    private Node queueNode;

    private Airplane airplane;

    public AirplaneInSystem() {
        this.presence = false;
        this.waiting = false;
        this.airplane = new Airplane();
        departureRunwayId = -1;
        queueNode = null;
    }

    public AirplaneInSystem(Airplane airplane) {
        this.presence = false;
        this.waiting = false;
        this.airplane = airplane;
        departureRunwayId = -1;
        queueNode = null;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public boolean isPresent() {
        return presence;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getRunwayDemandDate() {
        return runwayDemandDate;
    }

    public void setRunwayDemandDate(Date runwayDemandDate) {
        this.runwayDemandDate = runwayDemandDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public int getDepartureRunwayId() {
        return departureRunwayId;
    }

    public void setDepartureRunwayId(int departureRunwayId) {
        this.departureRunwayId = departureRunwayId;
    }

    public Node getQueueNode() {
        return queueNode;
    }

    public void setQueueNode(Node queueNode) {
        this.queueNode = queueNode;
    }
}
