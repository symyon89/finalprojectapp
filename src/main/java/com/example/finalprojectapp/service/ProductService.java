package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.exception.ProductNotFoundException;
import com.example.finalprojectapp.model.Manufacturer;
import com.example.finalprojectapp.model.Product;
import com.example.finalprojectapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class ProductService {

    private final ProductRepository productRepository;
    private final ManufacturerService manufacturerService;
    private final ModelMapper modelMapper;

    public List<ProductDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .toList();
    }

    public ProductDto save(@Valid ProductDto productDto){
        Product product = modelMapper.map(productDto,Product.class);
        checkIsManufacturerExistsAndGetManufacturer(productDto,product);
        checkIsProductExists(productDto.getId());
        return modelMapper.map(productRepository.save(product),ProductDto.class);
    }

    public ProductDto findById(UUID id) {
        return modelMapper.map(productRepository.findById(id).orElseThrow(ProductNotFoundException::new),ProductDto.class);
    }

    public void deleteById(UUID id) {
        checkIsProductExists(id);
        productRepository.deleteById(id);
    }

    private void checkIsManufacturerExistsAndGetManufacturer(ProductDto productDto, Product product){
        if (productDto.getManufacturerID() != null)
            product.setManufacturer(modelMapper.map(manufacturerService.findById(productDto.getManufacturerID()), Manufacturer.class));
    }

    private void checkIsProductExists(UUID id){
        if (id != null)
            this.findById(id);
    }
}
