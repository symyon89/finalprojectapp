package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.CustomerDto;
import com.example.finalprojectapp.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto modelToDto (Customer customer);
    List<CustomerDto> modelToDtos(List<Customer> customers);
    Customer dtoToModel (CustomerDto customerDto);
}
