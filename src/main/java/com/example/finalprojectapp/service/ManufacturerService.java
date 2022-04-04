package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.exception.ManufacturerNotFoundException;
import com.example.finalprojectapp.model.Manufacturer;
import com.example.finalprojectapp.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ModelMapper modelMapper;

    public List<ManufacturerDto> findAll() {
        return manufacturerRepository.findAll()
                .stream()
                .map(manufacturer -> modelMapper.map(manufacturer,ManufacturerDto.class))
                .toList();
    }

    public ManufacturerDto findById(UUID id){
        return modelMapper.map(manufacturerRepository.findById(id).orElseThrow(ManufacturerNotFoundException::new),ManufacturerDto.class);
    }

    public ManufacturerDto save(@Valid ManufacturerDto manufacturerDto) {
        this.checkIfManufacturerExists(manufacturerDto.getId());
        return modelMapper.map(manufacturerRepository.save(modelMapper.map(manufacturerDto, Manufacturer.class)),ManufacturerDto.class);
    }

    public void deleteById(UUID id) {
        this.checkIfManufacturerExists(id);
        manufacturerRepository.deleteById(id);
    }

    private void checkIfManufacturerExists(UUID manufacturerDtoId) {
        this.findById(manufacturerDtoId);
    }

}
