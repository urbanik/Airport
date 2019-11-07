package com.urbanik.mappers;

public interface BaseMapper<E, D> {
    D entityToDto(E entity);
    E dtoToEntity(D dto);
}
