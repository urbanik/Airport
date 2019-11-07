package com.urbanik.core;

import com.urbanik.date.Date;
import com.urbanik.dto.AirplaneDto;
import com.urbanik.dto.AirplaneInSystemDto;
import com.urbanik.dto.RunwayDto;
import com.urbanik.entity.*;
import com.urbanik.mappers.AirplaneInSystemMapper;
import com.urbanik.mappers.AirplaneMapper;
import com.urbanik.mappers.RunwayMapper;
import com.urbanik.structures.SplayTree;

import java.util.ArrayList;
import java.util.Random;

public class Airport {

    private SplayTree<AirplaneByCode> airplanesByCode;
    private SplayTree<AirplaneInSystemByCode> airplanesInSystemByCode;
    private SplayTree<AirplaneInSystemByCode> waitingPlanesByCode;
    private SplayTree<RunwayGroup> runwayGroups;
    private SplayTree<Runway> runways;
    private Date systemDate;
    private AirplaneInSystemMapper airplaneInSystemMapper;
    private RunwayMapper runwayMapper;
    private AirplaneMapper airplaneMapper;
    int actualRunwayId;

    RunwayGroup rg1500;
    RunwayGroup rg2000;
    RunwayGroup rg2500;
    RunwayGroup rg3000;
    RunwayGroup rg3500;

    Random random;

    public Airport() {

        airplanesByCode = new SplayTree();
        airplanesInSystemByCode = new SplayTree();
        waitingPlanesByCode = new SplayTree();
        runwayGroups = new SplayTree();
        runways = new SplayTree();
        systemDate = new Date(12,1,1,2019);
        airplaneInSystemMapper = new AirplaneInSystemMapper();
        runwayMapper = new RunwayMapper();
        airplaneMapper = new AirplaneMapper();
        actualRunwayId = 1;

        random = new Random();

        rg1500 = new RunwayGroup(1500);
        rg2000 = new RunwayGroup(2000);
        rg2500 = new RunwayGroup(2500);
        rg3000 = new RunwayGroup(3000);
        rg3500 = new RunwayGroup(3500);

        runwayGroups.insert(rg1500);
        runwayGroups.insert(rg2000);
        runwayGroups.insert(rg2500);
        runwayGroups.insert(rg3000);
        runwayGroups.insert(rg3500);

        /*Runway r1 = new Runway(1, 1500);
        Runway r2 = new Runway(2, 1500);
        Runway r3 = new Runway(3, 1500);
        Runway r4 = new Runway(4, 2000);
        Runway r5 = new Runway(5, 2000);
        Runway r6 = new Runway(6, 2000);
        Runway r7 = new Runway(7, 2500);
        Runway r8 = new Runway(8, 2500);
        Runway r9 = new Runway(9, 2500);
        Runway r10 = new Runway(10, 3000);
        Runway r11 = new Runway(11, 3000);
        Runway r12 = new Runway(12, 3000);
        Runway r13 = new Runway(13,3500);
        Runway r14 = new Runway(14,3500);

        runways.insert(r1);
        runways.insert(r2);
        runways.insert(r3);
        runways.insert(r4);
        runways.insert(r5);
        runways.insert(r6);
        runways.insert(r7);
        runways.insert(r8);
        runways.insert(r9);
        runways.insert(r10);
        runways.insert(r11);
        runways.insert(r12);
        runways.insert(r13);
        runways.insert(r14);

        rg1.getRunwaysTree().insert(r1);
        rg1.getRunwaysTree().insert(r2);
        rg1.getRunwaysTree().insert(r3);
        rg2.getRunwaysTree().insert(r4);
        rg2.getRunwaysTree().insert(r5);
        rg2.getRunwaysTree().insert(r6);
        rg3.getRunwaysTree().insert(r7);
        rg3.getRunwaysTree().insert(r8);
        rg3.getRunwaysTree().insert(r9);
        rg4.getRunwaysTree().insert(r10);
        rg4.getRunwaysTree().insert(r11);
        rg4.getRunwaysTree().insert(r12);
        rg5.getRunwaysTree().insert(r13);
        rg5.getRunwaysTree().insert(r14);

        rg1.getRunwaysList().add(r1);
        rg1.getRunwaysList().add(r2);
        rg1.getRunwaysList().add(r3);
        rg2.getRunwaysList().add(r4);
        rg2.getRunwaysList().add(r5);
        rg2.getRunwaysList().add(r6);
        rg3.getRunwaysList().add(r7);
        rg3.getRunwaysList().add(r8);
        rg3.getRunwaysList().add(r9);
        rg4.getRunwaysList().add(r10);
        rg4.getRunwaysList().add(r11);
        rg4.getRunwaysList().add(r12);
        rg5.getRunwaysList().add(r13);
        rg5.getRunwaysList().add(r14);*/



        Airplane a1 = new Airplane("Boeing", "737", "abcd", 2700, 1);
        Airplane a2 = new Airplane("Boeing", "747", "efgh", 3500, 4);
        Airplane a3 = new Airplane("Boeing", "757", "ijkl", 2700, 3);
        Airplane a4 = new Airplane("Boeing", "767", "mnop", 3500, 2);
        Airplane a5 = new Airplane("Boeing", "777", "qrst", 3500, 2);
        Airplane a6 = new Airplane("Boeing", "787", "uvxy", 3500, 1);
        Airplane a7 = new Airplane("Boeing", "789", "zzzz", 3500, 3);

        AirplaneInSystem ai1 = new AirplaneInSystem(a1);
        AirplaneInSystem ai2 = new AirplaneInSystem(a2);
        AirplaneInSystem ai3 = new AirplaneInSystem(a3);
        AirplaneInSystem ai4 = new AirplaneInSystem(a4);
        AirplaneInSystem ai5 = new AirplaneInSystem(a5);
        AirplaneInSystem ai6 = new AirplaneInSystem(a6);
        AirplaneInSystem ai7 = new AirplaneInSystem(a7);

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

    public AirplaneInSystemDto planeArrived(AirplaneInSystemDto airplaneInSystemDto){ // 1

        // dto to enetity
        AirplaneInSystem airplaneInSystem = airplaneInSystemMapper.dtoToEntity(airplaneInSystemDto);
        // najdem v strome
        AirplaneByCode toFind = new AirplaneByCode();
        toFind.setAirplane(airplaneInSystem.getAirplane());
        if(airplanesByCode.find(toFind) == null) {
            return null;
        } else {
            AirplaneByCode found = (AirplaneByCode) airplanesByCode.find(toFind).getData();
            // lietadlo uz je v systeme, nastavim mu atributy (priletelo)
            airplaneInSystem.setAirplane(found.getAirplane());
            airplaneInSystem.setArrivalDate(systemDate);
            airplaneInSystem.setPresence(true);
        }



        // overenie ci uz nepriletelo
        AirplaneInSystemByCode airplaneInSystemByCode = new AirplaneInSystemByCode(airplaneInSystem);
        if(airplanesInSystemByCode.find(airplaneInSystemByCode) == null){

            airplanesInSystemByCode.insert(airplaneInSystemByCode);
            return airplaneInSystemMapper.entityToDto(airplaneInSystem);

        } else {
            return null;
        }


    }

    public void planeArrived(AirplaneByCode airplaneByCode){ // 1 generovanie

        AirplaneInSystem airplaneInSystem = new AirplaneInSystem();
            // lietadlo uz je v systeme, nastavim mu atributy (priletelo)
        airplaneInSystem.setAirplane(airplaneByCode.getAirplane());
        airplaneInSystem.setArrivalDate(systemDate);
        airplaneInSystem.setPresence(true);


        // overenie ci uz nepriletelo
        AirplaneInSystemByCode airplaneInSystemByCode = new AirplaneInSystemByCode(airplaneInSystem);
        if(airplanesInSystemByCode.find(airplaneInSystemByCode) == null){

            airplanesInSystemByCode.insert(airplaneInSystemByCode);

        } else {

            return;

        }

    }

    public AirplaneInSystemDto demandRunway(AirplaneInSystemDto airplaneInSystemDto){ // 2

        // dto to enetity
        AirplaneInSystem airplaneInSystem = airplaneInSystemMapper.dtoToEntity(airplaneInSystemDto);
        // najdem v strome
        AirplaneInSystemByCode toFind = new AirplaneInSystemByCode();
        toFind.setAirplaneInSystem(airplaneInSystem);
        AirplaneInSystemByCode found = (AirplaneInSystemByCode) airplanesInSystemByCode.find(toFind).getData();


        if(found != null) {

            // lietadlo uz je v systeme, nastavim mu atributy
            airplaneInSystem.setAirplane(found.getAirplaneInSystem().getAirplane());
            // by priority
            AirplaneInSystemByPriority byPriority = new AirplaneInSystemByPriority(airplaneInSystem);

            RunwayGroup tmpGroup = new RunwayGroup();
            tmpGroup.setRunwayLength(airplaneInSystem.getAirplane().getSystemDepartureLength());
            RunwayGroup group = runwayGroups.find(tmpGroup).getData();

            boolean freeRunway = false;
            for (Runway rw : group.getRunwaysList()) {
                if (!rw.isOccupated()) {
                    freeRunway = true;
                    byPriority.getAirplaneInSystem().setRunwayDemandDate(systemDate);
                    byPriority.getAirplaneInSystem().setDepartureRunwayId(rw.getId()); // DOPLNANIE TOHTO ATRIBUTU PRI ODJAZDE
                    rw.setOccupated(true);

                    break;
                }
            }
            if (!freeRunway) {
                byPriority.getAirplaneInSystem().setWaiting(true);
                byPriority.getAirplaneInSystem().setRunwayDemandDate(systemDate);
                byPriority.getAirplaneInSystem().setQueueNode(group.getPlanesQueue().insert(byPriority)); // ulozim si referenciu na node z haldy
                AirplaneInSystemByCode airplaneInSystemByCode = new AirplaneInSystemByCode(airplaneInSystem);
                group.getWaitingPlanesTree().insert(airplaneInSystemByCode);
                waitingPlanesByCode.insert(airplaneInSystemByCode);

            }
            return airplaneInSystemMapper.entityToDto(byPriority.getAirplaneInSystem());
        }else{
            return null;
        }
    }

    public void demandRunway(AirplaneInSystem airplaneInSystem){ // 2

        // najdem v strome
        AirplaneInSystemByCode toFind = new AirplaneInSystemByCode();
        toFind.setAirplaneInSystem(airplaneInSystem);
        AirplaneInSystemByCode found = (AirplaneInSystemByCode) airplanesInSystemByCode.find(toFind).getData();

        if(found != null) {

            // lietadlo uz je v systeme, nastavim mu atributy
            airplaneInSystem.setAirplane(found.getAirplaneInSystem().getAirplane());
            // by priority
            AirplaneInSystemByPriority byPriority = new AirplaneInSystemByPriority(airplaneInSystem);

            RunwayGroup tmpGroup = new RunwayGroup();
            tmpGroup.setRunwayLength(airplaneInSystem.getAirplane().getSystemDepartureLength());
            RunwayGroup group = runwayGroups.find(tmpGroup).getData();

            boolean freeRunway = false;
            for (Runway rw : group.getRunwaysList()) {
                if (!rw.isOccupated()) {
                    freeRunway = true;
                    byPriority.getAirplaneInSystem().setRunwayDemandDate(systemDate);
                    byPriority.getAirplaneInSystem().setDepartureRunwayId(rw.getId()); // DOPLNANIE TOHTO ATRIBUTU PRI ODJAZDE
                    rw.setOccupated(true);

                    break;
                }
            }
            if (!freeRunway) {
                byPriority.getAirplaneInSystem().setWaiting(true);
                byPriority.getAirplaneInSystem().setRunwayDemandDate(systemDate);
                byPriority.getAirplaneInSystem().setQueueNode(group.getPlanesQueue().insert(byPriority)); // ulozim si referenciu na node z haldy
                AirplaneInSystemByCode airplaneInSystemByCode = new AirplaneInSystemByCode(airplaneInSystem);
                group.getWaitingPlanesTree().insert(airplaneInSystemByCode);
                waitingPlanesByCode.insert(airplaneInSystemByCode);

            }

        }else{

            return;
        }
    }

    public ArrayList<AirplaneInSystemDto> getWaitingAirplanes() { // 6

        ArrayList<AirplaneInSystemDto> dtos = new ArrayList<>();

        for (AirplaneInSystemByCode apbc : this.waitingPlanesByCode.inOrderToList()) {
            dtos.add(airplaneInSystemMapper.entityToDto(apbc.getAirplaneInSystem()));
        }

        return dtos;
    }

    public AirplaneInSystemDto getWaitingAirplaneByCode(AirplaneInSystemDto airplaneInSystemDto){ // 3

        AirplaneInSystem airplaneInSystem = airplaneInSystemMapper.dtoToEntity(airplaneInSystemDto);
        AirplaneInSystemByCode toFind = new AirplaneInSystemByCode();
        toFind.setAirplaneInSystem(airplaneInSystem);
        AirplaneInSystemByCode byCode = (AirplaneInSystemByCode) waitingPlanesByCode.find(toFind).getData();
        return airplaneInSystemMapper.entityToDto(byCode.getAirplaneInSystem());
    }

    public ArrayList<AirplaneInSystemDto> getWaitingAirplanesOnRunwayGroup(RunwayDto runwayDto, AirplaneInSystemDto airplaneInSystemDto){ // 4

        ArrayList<AirplaneInSystemDto> dtos = new ArrayList<>();
        Runway runway = runwayMapper.dtoToEntity(runwayDto);
        Runway toFind = runways.find(runway).getData();

        RunwayGroup tmpGroup = new RunwayGroup();
        tmpGroup.setRunwayLength(toFind.getLength());
        RunwayGroup group = runwayGroups.find(tmpGroup).getData();

        if(airplaneInSystemDto != null) {

            for (AirplaneInSystemByCode apisbc : group.getWaitingPlanesTree().inOrderToList()) {
                dtos.add(airplaneInSystemMapper.entityToDto(apisbc.getAirplaneInSystem()));
            }
        } else {

            AirplaneInSystem airplaneInSystem = airplaneInSystemMapper.dtoToEntity(airplaneInSystemDto);
            AirplaneInSystemByCode airplaneInSystemByCode = new AirplaneInSystemByCode();
            airplaneInSystemByCode.setAirplaneInSystem(airplaneInSystem);
            AirplaneInSystemByCode byCode = (AirplaneInSystemByCode) waitingPlanesByCode.find(airplaneInSystemByCode).getData();
            dtos.add(airplaneInSystemMapper.entityToDto(byCode.getAirplaneInSystem()));
        }
        return dtos;
    }

    public AirplaneInSystemDto getNextPlaneAfterDepartureOfOne(AirplaneInSystemDto dto) { // 5
        // z gui objektu na domenu
        AirplaneInSystem airplaneInSystem = airplaneInSystemMapper.dtoToEntity(dto);
        AirplaneInSystemByCode toFind = new AirplaneInSystemByCode();
        toFind.setAirplaneInSystem(airplaneInSystem);
        // najdem lietadlo a nastavim atributy
        AirplaneInSystemByCode found = (AirplaneInSystemByCode) airplanesInSystemByCode.find(toFind).getData();
        found.getAirplaneInSystem().setDepartureDate(systemDate);
        found.getAirplaneInSystem().setPresence(false);
        found.getAirplaneInSystem().setWaiting(false);
        // ulozim si z ktorej drahy letelo a pridam ho do historie
        int rw = found.getAirplaneInSystem().getDepartureRunwayId();
        RunwayGroup runwayGroup = this.runwayGroups.find(new RunwayGroup(found.getAirplaneInSystem().getAirplane().getSystemDepartureLength())).getData();
        Runway r = runwayGroup.getRunwaysTree().find(new Runway(rw)).getData();
        r.getHistory().add(found.getAirplaneInSystem());
        // nastavim drahu na obsadenu
        r.setOccupated(false);
        // odstranim zo stromov
        this.waitingPlanesByCode.remove(found);
        runwayGroup.getWaitingPlanesTree().remove(found);
        runwayGroup.getPlanesQueue().removeMinimum();

        //ak nejake caka v rade, pridelim mu drahu
        if(runwayGroup.getPlanesQueue().getRoot() != null) {
            AirplaneInSystemByPriority nextByPriority = (AirplaneInSystemByPriority) runwayGroup.getPlanesQueue().getRoot().getData();
            AirplaneInSystem next = nextByPriority.getAirplaneInSystem();
            next.setWaiting(false);
            next.setDepartureRunwayId(rw);
            // vymazem zo stromov
            AirplaneInSystemByCode byCode = new AirplaneInSystemByCode(next);
            this.waitingPlanesByCode.remove(byCode);
            runwayGroup.getWaitingPlanesTree().remove(byCode);
            return airplaneInSystemMapper.entityToDto(next);
        }else {
            return null;
        }
    }

    public ArrayList<RunwayDto> getHisory() { // 9

        ArrayList<RunwayDto> runwayDtos = new ArrayList<>();
        for (Runway rw : runways.inOrderToList()) {

            ArrayList<AirplaneInSystemDto> airplaneDtos = new ArrayList<>();
            for (AirplaneInSystem api : rw.getHistory()) {
                airplaneDtos.add(airplaneInSystemMapper.entityToDto(api));
            }

            RunwayDto runwayDto = runwayMapper.entityToDto(rw);
            runwayDto.setHistory(airplaneDtos);
            runwayDtos.add(runwayDto);
        }
        return runwayDtos;
    }

    public boolean changePriorityOfPlane(AirplaneInSystemDto airplaneDto, int priority) { // 9

        AirplaneInSystem airplaneInSystem = airplaneInSystemMapper.dtoToEntity(airplaneDto);
        AirplaneInSystemByCode toFind = new AirplaneInSystemByCode();
        toFind.setAirplaneInSystem(airplaneInSystem);
        // najdem lietadlo a nastavim atributy
        AirplaneInSystemByCode found = (AirplaneInSystemByCode) airplanesInSystemByCode.find(toFind).getData();
        if(found != null) {
            AirplaneInSystemByCode tmp = new AirplaneInSystemByCode();
            tmp.setAirplaneInSystem(found.getAirplaneInSystem());
            tmp.getAirplaneInSystem().getAirplane().setPriority(priority);
            RunwayGroup tmpGroup = new RunwayGroup(found.getAirplaneInSystem().getAirplane().getSystemDepartureLength());
            RunwayGroup rwg = runwayGroups.find(tmpGroup).getData();

            // nastavim prioritu
            if (priority > found.getAirplaneInSystem().getAirplane().getPriority()) {
                rwg.getPlanesQueue().priorityUp(found.getAirplaneInSystem().getQueueNode(), tmp);

            } else if (priority < found.getAirplaneInSystem().getAirplane().getPriority()) {
                rwg.getPlanesQueue().priorityDown(found.getAirplaneInSystem().getQueueNode(), tmp);
            } else {
                System.out.println("Neporovnalo priority!");
            }

            return true;

        }else{

            return false;
        }
    }

    public boolean stopRunwayDemand(AirplaneInSystemDto airplaneDto) { // 9

        AirplaneInSystem airplaneInSystem = airplaneInSystemMapper.dtoToEntity(airplaneDto);
        AirplaneInSystemByCode toFind = new AirplaneInSystemByCode();
        toFind.setAirplaneInSystem(airplaneInSystem);
        // najdem lietadlo a nastavim atributy

        AirplaneInSystemByCode found = (AirplaneInSystemByCode) airplanesInSystemByCode.find(toFind).getData();
        if(found != null) {
            AirplaneInSystemByCode tmp = found;
            RunwayGroup tmpGroup = new RunwayGroup(found.getAirplaneInSystem().getAirplane().getSystemDepartureLength());
            RunwayGroup rwg = runwayGroups.find(tmpGroup).getData();

            // nastavim velku prioritu a odstranim zo stromov
            tmp.getAirplaneInSystem().getAirplane().setPriority(-5000);
            rwg.getPlanesQueue().remove(found.getAirplaneInSystem().getQueueNode(), tmp);
            rwg.getWaitingPlanesTree().remove(found);
            waitingPlanesByCode.remove(found);
            return true;

        }else{
            return false;
        }
    }

   public boolean addPlane(AirplaneDto airplaneDto) {

       // kontrola na unikatnost kodu
       Airplane airplane = airplaneMapper.dtoToEntity(airplaneDto);
       AirplaneByCode airplaneByCode = new AirplaneByCode(airplane);
       if(airplanesByCode.find(airplaneByCode) == null) {

           this.airplanesByCode.insert(airplaneByCode);
           return true;

       } else {

           return false;

       }
   }

    public void generateRunways(int parseInt) {

        for(int i = 0; i <= parseInt; i++){

            for(int j = 0; i < 5; i++) {

                Runway r1 = new Runway(actualRunwayId, 1500);
                rg1500.getRunwaysList().add(r1);
                rg1500.getRunwaysTree().insert(r1);
                runways.insert(r1);
                actualRunwayId++;

                Runway r2 = new Runway(actualRunwayId, 2000);
                rg2000.getRunwaysList().add(r2);
                rg2000.getRunwaysTree().insert(r2);
                runways.insert(r2);
                actualRunwayId++;

                Runway r3 = new Runway(actualRunwayId, 2500);
                rg2500.getRunwaysList().add(r3);
                rg2500.getRunwaysTree().insert(r3);
                runways.insert(r3);
                actualRunwayId++;

                Runway r4 = new Runway(actualRunwayId, 3000);
                rg3000.getRunwaysList().add(r4);
                rg3000.getRunwaysTree().insert(r4);
                runways.insert(r4);
                actualRunwayId++;

                Runway r5 = new Runway(actualRunwayId, 3500);
                rg3500.getRunwaysList().add(r5);
                rg3500.getRunwaysTree().insert(r5);
                runways.insert(r5);
                actualRunwayId++;

            }
        }
    }

    public void generatePlanes(int parseInt) {

        for(int i = 0; i <= parseInt; i++){

            String manufacturer = null;
            String type = null;
            String code = null;
            int minDepartureLength = 0;
            int priority = 0;

            int manufacturerR = random.nextInt(2);
            switch(manufacturerR){
                case 0 : {
                    manufacturer = "Airbus";
                    int typeA = random.nextInt(5);
                    switch(typeA){
                        case 0 : {
                            type = "A220";
                            break;
                        }
                        case 1 : {
                            type = "A300";
                            break;
                        }
                        case 2 : {
                            type = "A319";
                            break;
                        }
                        case 3 : {
                            type = "A340";
                            break;
                        }
                        case 4 : {
                            type = "A380";
                            break;
                        }
                    }
                    break;
                }
                case 1 : {
                    manufacturer = "Boeing";
                    int typeB = random.nextInt(5);
                    switch(typeB){
                        case 0 : {
                            type = "737";
                            break;
                        }
                        case 1 : {
                            type = "747";
                            break;
                        }
                        case 2 : {
                            type = "757";
                            break;
                        }
                        case 3 : {
                            type = "767";
                            break;
                        }
                        case 4 : {
                            type = "777";
                            break;
                        }
                    }
                    break;
                }
            }

            code = createCode();
            minDepartureLength = random.nextInt(3500);
            priority = random.nextInt(10);

            Airplane brandNew = new Airplane(manufacturer, type, code, minDepartureLength, priority);
            airplanesByCode.insert(new AirplaneByCode(brandNew));
        }
    }

    private final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private final String NUMBER = "0123456789";

    private final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;

    public String createCode() {

        int length = 16;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);

        }
        return sb.toString();
    }

    public void makePlanesArrive() {
        for (AirplaneByCode apbc : airplanesByCode.inOrderToList()) {
            planeArrived(apbc);
        }
    }

    public void makePlanesDemandRunway() {
        for (AirplaneInSystemByCode apis : airplanesInSystemByCode.inOrderToList()) {
            demandRunway(apis.getAirplaneInSystem());
        }
    }
}
