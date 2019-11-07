package com.urbanik.mappers;

import com.urbanik.dto.RunwayDto;
import com.urbanik.entity.Runway;

public class RunwayMapper implements BaseMapper<Runway, RunwayDto> {

    @Override
    public RunwayDto entityToDto(Runway entity) {
        RunwayDto dto = new RunwayDto();
        dto.setId(entity.getId());
        dto.setLength(entity.getLength());
        //dto.setHistory(entity.getHistory());
        return dto;
    }

    @Override
    public Runway dtoToEntity(RunwayDto dto) {
        Runway entity = new Runway();
        entity.setId(dto.getId());
        entity.setLength(dto.getLength());
        return entity;
    }
}
