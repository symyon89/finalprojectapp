package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.VatDto;
import com.example.finalprojectapp.model.Vat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VatMapper {
    VatDto modelToDto (Vat vat);
    List<VatDto> modelToDtos(List<Vat> vats);
    Vat dtoToModel (VatDto vatDto);
}
