package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.CustomerDto;
import com.example.finalprojectapp.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mappings({
            @Mapping(source = "active",target = "isActive"),
            @Mapping(source = "company",target = "isCompany")
    })
    CustomerDto modelToDto (Customer customer);
    List<CustomerDto> modelToDtos(List<Customer> customers);
    @Mappings({
            @Mapping(source = "active",target = "isActive"),
            @Mapping(source = "company",target = "isCompany")
    })
    Customer dtoToModel (CustomerDto customerDto);
}
