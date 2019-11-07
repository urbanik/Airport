package com.urbanik.mappers;

import com.urbanik.dto.AirplaneDto;
import com.urbanik.entity.Airplane;

public class AirplaneMapper implements BaseMapper<Airplane, AirplaneDto>{

    public AirplaneMapper() {
    }

    @Override
    public AirplaneDto entityToDto(Airplane entity) {

        AirplaneDto dto = new AirplaneDto();
        dto.setManufacturer(entity.getManufacturer());
        dto.setType(entity.getType());
        dto.setCode(entity.getCode());
        dto.setMinDepartureRunwayLength(entity.getMinDepartureRunwayLength());
        dto.setPriority(entity.getPriority());
        return dto;
    }

    @Override
    public Airplane dtoToEntity(AirplaneDto dto) {

        Airplane airplane = new Airplane();
        airplane.setManufacturer(dto.getManufacturer());
        airplane.setType(dto.getType());
        airplane.setCode(dto.getCode());
        airplane.setMinDepartureRunwayLength(dto.getMinDepartureRunwayLength());
        airplane.setPriority(dto.getPriority());
        airplane.setSystemDepartureLength();
        return airplane;
    }
}
