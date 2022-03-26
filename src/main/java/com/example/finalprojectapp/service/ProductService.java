package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .toList();
    }
}
