package com.example.finalprojectapp.service;


import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.exception.ProductNotFoundException;
import com.example.finalprojectapp.mapper.ProductMapper;
import com.example.finalprojectapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final VatService vatService;


    public List<ProductDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::modelToDto)
                .map(this::calculatePriceWithVat)
                .toList();
    }

    public ProductDto saveNewProduct(@Valid ProductDto productDto) {
            return this.calculatePriceWithVat(productMapper.modelToDto(productRepository.save(productMapper.dtoToModel(productDto))));
    }



    public ProductDto saveExistingProduct(@Valid ProductDto productDto) {
        this.findById(productDto.getId());
        return this.calculatePriceWithVat(productMapper.modelToDto(productRepository.save(productMapper.dtoToModel(productDto))));
    }

    public ProductDto findById(UUID id) {
        return this.calculatePriceWithVat(productMapper.modelToDto(productRepository.findById(id).orElseThrow(ProductNotFoundException::new)));
    }

    public void deleteById(UUID id) {
        this.findById(id);
        productRepository.deleteById(id);
    }

    private ProductDto calculatePriceWithVat(ProductDto productDto) {
        if (productDto.getVat() != null)
            productDto.setPriceWithVat(productDto.getPrice() * ((vatService.findById(productDto.getVat().getId()).getPercentage() / 100)+1));
        else
            productDto.setPriceWithVat(productDto.getPrice());
        return productDto;
    }

}
