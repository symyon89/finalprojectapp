package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "manufacturer",target = "manufacturerDto"),
            @Mapping(source = "vat",target = "vatDto")
    })
    ProductDto modelToDto (Product product);
    @InheritInverseConfiguration
    Product dtoToModel (ProductDto productDto);
}
