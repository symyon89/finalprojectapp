package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.CustomerDto;
import com.example.finalprojectapp.exception.ProductNotFoundException;
import com.example.finalprojectapp.mapper.CustomerMapper;
import com.example.finalprojectapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerDto> findAllProducts() {
        return customerMapper.modelToDtos(customerRepository.findAll());
    }

    public CustomerDto saveNewProduct(@Valid CustomerDto customerDto) {
        return customerMapper.modelToDto(customerRepository.save(customerMapper.dtoToModel(customerDto)));
    }

    public CustomerDto saveExistingProduct(@Valid CustomerDto customerDto) {
        this.findById(customerDto.getId());
        return customerMapper.modelToDto(customerRepository.save(customerMapper.dtoToModel(customerDto)));
    }

    public CustomerDto findById(UUID id) {
        return customerMapper.modelToDto(customerRepository.findById(id).orElseThrow(ProductNotFoundException::new));
    }

    public void deleteById(UUID id) {
        this.findById(id);
        customerRepository.deleteById(id);
    }
}
