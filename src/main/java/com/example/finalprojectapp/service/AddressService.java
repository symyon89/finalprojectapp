package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.AddressDto;
import com.example.finalprojectapp.exception.AddressNotFoundException;
import com.example.finalprojectapp.exception.InvalidUUIDException;
import com.example.finalprojectapp.mapper.AddressMapper;
import com.example.finalprojectapp.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;



    public List<AddressDto> findAll() {
        return addressMapper.modelToDtos(addressRepository.findAll());
    }

    public AddressDto findById(UUID id) {
        return addressMapper.modelToDto(addressRepository.findById(id).orElseThrow(AddressNotFoundException::new));
    }

    public AddressDto saveNew(@Valid AddressDto addressDto) {
        this.checkIfIdIsEmpty(addressDto);
        return addressMapper.modelToDto(addressRepository.save(addressMapper.dtoToModel(addressDto)));
    }

    public void deleteById(UUID id) {
        this.checkIfVatExists(id);
        addressRepository.deleteById(id);
    }

    private void checkIfVatExists(UUID id) {
        this.findById(id);
    }

    private void checkIfIdIsEmpty(AddressDto addressDto) {
        if (addressDto.getId() != null)
            throw new InvalidUUIDException();
    }

    public AddressDto saveExisting(@Valid AddressDto addressDto) {
        this.checkIfVatExists(addressDto.getId());
        return addressMapper.modelToDto(addressRepository.save(addressMapper.dtoToModel(addressDto)));
    }
}
