package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.model.Manufacturer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    ManufacturerDto modelToDto (Manufacturer manufacturer);
    List<ManufacturerDto> modelToDtos(List<Manufacturer> manufacturers);
    Manufacturer dtoToModel (ManufacturerDto manufacturerDto);
}
