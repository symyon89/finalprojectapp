package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.dto.VatDto;
import com.example.finalprojectapp.model.Manufacturer;
import com.example.finalprojectapp.model.Vat;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VatMapper {
    VatDto modelToDto (Vat vat);
    List<VatDto> modelToDtos(List<Vat> vats);
    Vat dtoToModel (VatDto vatDto);
}
