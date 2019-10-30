package com.urbanik.core;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.urbanik.date.Date;
import com.urbanik.dto.AirplaneDto;
import com.urbanik.entity.*;
import com.urbanik.mappers.AirplaneMapper;
import com.urbanik.structures.SplayTree;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private SplayTree<AirplaneByCode> airplanesByCode;
    private SplayTree<AirplaneByCode> waitingPlanesByCode;
    private List<RunwayGroup> runwayGroups;
    private Date systemDate;
    private AirplaneMapper airplaneMapper;

    public Airport() {
        airplanesByCode = new SplayTree();
        waitingPlanesByCode = new SplayTree();
        runwayGroups = new ArrayList<>();
        systemDate = new Date(12,1,1,2019);
        airplaneMapper = new AirplaneMapper();

        Runway r1 = new Runway(1, 4500);
        Runway r2 = new Runway(2, 4500);
        Runway r3 = new Runway(3, 2700);

        RunwayGroup rg1 = new RunwayGroup(4500);
        rg1.getRunways().add(r1);
        rg1.getRunways().add(r2);

        runwayGroups.add(rg1);

        Airplane a1 = new Airplane("Boeing", "737", "abcd", 2700, 1);
        Airplane a2 = new Airplane("Boeing", "747", "efgh", 3500, 4);
        Airplane a3 = new Airplane("Boeing", "757", "ijkl", 2700, 3);
        Airplane a4 = new Airplane("Boeing", "767", "mnop", 3500, 2);
        Airplane a5 = new Airplane("Boeing", "777", "qrst", 4500, 2);
        Airplane a6 = new Airplane("Boeing", "787", "uvxy", 4500, 1);
        Airplane a7 = new Airplane("Boeing", "789", "zzzz", 4500, 3);

        airplanesByCode.insert(new AirplaneByCode(a1));
        airplanesByCode.insert(new AirplaneByCode(a2));
        airplanesByCode.insert(new AirplaneByCode(a3));
        airplanesByCode.insert(new AirplaneByCode(a4));
        airplanesByCode.insert(new AirplaneByCode(a5));
        airplanesByCode.insert(new AirplaneByCode(a6));
        airplanesByCode.insert(new AirplaneByCode(a7));


    }

    public String getSystemDate(){
        return systemDate.toString();
    }

    public void addHour(){
        this.systemDate.addHour();
    }

    public AirplaneDto planeArrived(AirplaneDto airplaneDto){

        Airplane airplane = airplaneMapper.dtoToEntity(airplaneDto);
        AirplaneByCode toFind = new AirplaneByCode();
        toFind.setAirplane(airplane);
        AirplaneByCode found = (AirplaneByCode) airplanesByCode.find(toFind).getData();
        found.getAirplane().setArrivalDate(systemDate);
        found.getAirplane().setPresence(true);

        return airplaneMapper.entityToDto(found.getAirplane());

    }

    public AirplaneDto demandRunway(AirplaneDto airplaneDto){

        Airplane airplane = airplaneMapper.dtoToEntity(airplaneDto);
        AirplaneByCode toFind = new AirplaneByCode();
        toFind.setAirplane(airplane);
        AirplaneByCode byCode = (AirplaneByCode) airplanesByCode.find(toFind).getData();
        AirplaneByPriority byPriority = new AirplaneByPriority(byCode.getAirplane());

        if(byPriority.getAirplane().isPresent()) {
            byPriority.getAirplane().setWaiting(true);
            byPriority.getAirplane().setRunwayDemandDate(systemDate);

            for (RunwayGroup rg : runwayGroups) {
                if (rg.getRunwayLength() >= byPriority.getAirplane().getMinDepartureRunwayLength()) {
                    rg.getWaitingPlanes().insert(byPriority);
                    rg.getWaitingPlanes().inOrderReversePrint();
                    break;
                }
            }

            waitingPlanesByCode.insert(byCode);
            return airplaneMapper.entityToDto(byPriority.getAirplane());
        } else{

            System.out.println("This plane has not arrived!");
            return null;
        }

    }

    public ArrayList<AirplaneDto> getWaitingAirplanes() {

        ArrayList<AirplaneDto> dtos = new ArrayList<>();

        for (AirplaneByCode apbc : this.waitingPlanesByCode.inOrderToList()) {
            dtos.add(airplaneMapper.entityToDto(apbc.getAirplane()));
        }

        return dtos;
    }

    public AirplaneDto getWaitingAirplaneByCode(AirplaneDto airplaneDto){

        Airplane airplane = airplaneMapper.dtoToEntity(airplaneDto);
        AirplaneByCode toFind = new AirplaneByCode();
        toFind.setAirplane(airplane);
        AirplaneByCode byCode = (AirplaneByCode) waitingPlanesByCode.find(toFind).getData();
        return airplaneMapper.entityToDto(byCode.getAirplane());
    }
}
