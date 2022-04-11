package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.AddressDto;
import com.example.finalprojectapp.model.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto modelToDto (Address address);
    List<AddressDto> modelToDtos(List<Address> addresses);
    Address dtoToModel (AddressDto addressDto);
}
