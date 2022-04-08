package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.exception.ProductNotFoundException;
import com.example.finalprojectapp.model.Manufacturer;
import com.example.finalprojectapp.model.Product;
import com.example.finalprojectapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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
    private final VatService vatService;
    private final ModelMapper modelMapper;

    public List<ProductDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .map(this::calculatePriceWithVat)
                .toList();
    }

    public ProductDto saveNewProduct(@Valid ProductDto productDto) {
            return this.calculatePriceWithVat(modelMapper.map(productRepository.save(modelMapper.map(productDto, Product.class)), ProductDto.class));
    }



    public ProductDto saveExistingProduct(@Valid ProductDto productDto) {
        this.findById(productDto.getId());
        return this.calculatePriceWithVat(modelMapper.map(productRepository.save(modelMapper.map(productDto, Product.class)), ProductDto.class));
    }

    public ProductDto findById(UUID id) {
        return this.calculatePriceWithVat(modelMapper.map(productRepository.findById(id).orElseThrow(ProductNotFoundException::new), ProductDto.class));
    }

    public void deleteById(UUID id) {
        this.findById(id);
        productRepository.deleteById(id);
    }

    private ProductDto calculatePriceWithVat(ProductDto productDto) {
        if (productDto.getVatDto() != null)
            productDto.setPriceWithVat(productDto.getPrice() + (vatService.findById(productDto.getVatDto().getId()).getPercentage() / 100.0));
        else
            productDto.setPriceWithVat(productDto.getPrice());
        return productDto;
    }

}
