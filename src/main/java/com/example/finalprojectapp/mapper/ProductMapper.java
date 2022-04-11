package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto modelToDto (Product product);
    Product dtoToModel (ProductDto productDto);

}
