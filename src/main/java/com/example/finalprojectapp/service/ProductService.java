package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.model.Manufacturer;
import com.example.finalprojectapp.model.Product;
import com.example.finalprojectapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class ProductService {

    private final ProductRepository productRepository;
    private final ManufacturerService manufacturerService;
    private final ModelMapper modelMapper;

    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .toList();
    }

    public ProductDto save(@Valid ProductDto productDto){
        Product product = modelMapper.map(productDto,Product.class);

        if (productDto.getManufacturerID() != null) {
            product.setManufacturer(modelMapper.map(manufacturerService.findById(productDto.getManufacturerID()), Manufacturer.class));
        }

        return modelMapper.map(productRepository.save(product),ProductDto.class);
    }
}
