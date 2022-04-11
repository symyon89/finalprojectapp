package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.AddressDto;
import com.example.finalprojectapp.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mappings({
            @Mapping(source = "primaryBilling",target = "isPrimaryBilling"),
            @Mapping(source = "primaryDelivery",target = "isPrimaryDelivery")
    })
    AddressDto modelToDto (Address address);
    List<AddressDto> modelToDtos(List<Address> addresses);
    @Mappings({
            @Mapping(source = "primaryBilling",target = "isPrimaryBilling"),
            @Mapping(source = "primaryDelivery",target = "isPrimaryDelivery")
    })
    Address dtoToModel (AddressDto addressDto);
}
