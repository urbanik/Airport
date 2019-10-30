package com.urbanik.mappers;

import com.urbanik.dto.AirplaneDto;
import com.urbanik.entity.Airplane;
import com.urbanik.entity.AirplaneByCode;

public class AirplaneMapper {

    public AirplaneMapper() {
    }

    public Airplane dtoToEntity(AirplaneDto airplaneDto){

        Airplane airplane = new Airplane();
        airplane.setCode(airplaneDto.getCode());

        return airplane;
    }

    public AirplaneDto entityToDto(Airplane airplane){

        AirplaneDto dto = new AirplaneDto();
        dto.setManufacturer(airplane.getManufacturer());
        dto.setType(airplane.getType());
        dto.setCode(airplane.getCode());
        dto.setMinDepartureRunwayLength(airplane.getMinDepartureRunwayLength());
        dto.setArrivalDate(airplane.getArrivalDate());
        dto.setRunwayDemandDate(airplane.getRunwayDemandDate());
        dto.setDepartureDate(airplane.getDepartureDate());
        dto.setPriority(airplane.getPriority());
        dto.setPresence(airplane.isPresent());
        dto.setWaiting(airplane.isWaiting());

        return dto;
    }
}
