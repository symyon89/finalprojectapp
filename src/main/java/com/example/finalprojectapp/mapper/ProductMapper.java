package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.model.Product;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto modelToDto (Product product);
    Product dtoToModel (ProductDto productDto);

}
