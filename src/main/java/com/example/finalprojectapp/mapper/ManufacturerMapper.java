package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.model.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    ManufacturerMapper INSTANCE = Mappers.getMapper(ManufacturerMapper.class);
    ManufacturerDto modelToDto (Manufacturer manufacturer);
    List<ManufacturerDto> modelToDtos(List<Manufacturer> manufacturers);
    Manufacturer dtoToModel (ManufacturerDto manufacturerDto);
}
