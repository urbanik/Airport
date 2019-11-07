package com.urbanik.mappers;

import com.urbanik.dto.AirplaneInSystemDto;
import com.urbanik.entity.AirplaneInSystem;

public class AirplaneInSystemMapper implements BaseMapper<AirplaneInSystem, AirplaneInSystemDto>{

    public AirplaneInSystemMapper() {
    }

    public AirplaneInSystem dtoToEntity(AirplaneInSystemDto airplaneInSystemDto){

        AirplaneInSystem airplaneInSystem = new AirplaneInSystem();
        airplaneInSystem.getAirplane().setCode(airplaneInSystemDto.getCode());

        return airplaneInSystem;
    }

    public AirplaneInSystemDto entityToDto(AirplaneInSystem airplaneInSystem){

        AirplaneInSystemDto dto = new AirplaneInSystemDto();
        dto.setManufacturer(airplaneInSystem.getAirplane().getManufacturer());
        dto.setType(airplaneInSystem.getAirplane().getType());
        dto.setCode(airplaneInSystem.getAirplane().getCode());
        dto.setMinDepartureRunwayLength(airplaneInSystem.getAirplane().getMinDepartureRunwayLength());
        dto.setSystemDepartureLength(airplaneInSystem.getAirplane().getSystemDepartureLength());
        dto.setArrivalDate(airplaneInSystem.getArrivalDate());
        dto.setRunwayDemandDate(airplaneInSystem.getRunwayDemandDate());
        dto.setDepartureRunwayId(airplaneInSystem.getDepartureRunwayId());
        dto.setDepartureDate(airplaneInSystem.getDepartureDate());
        dto.setPriority(airplaneInSystem.getAirplane().getPriority());
        dto.setPresence(airplaneInSystem.isPresent());
        dto.setWaiting(airplaneInSystem.isWaiting());

        return dto;
    }
}
