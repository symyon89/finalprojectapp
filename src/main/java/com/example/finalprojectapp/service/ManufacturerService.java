package com.example.finalprojectapp.service;

import com.example.finalprojectapp.config.GenericListMapper;
import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.exception.InvalidUUIDException;
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

import static com.example.finalprojectapp.config.GenericListMapper.mapList;

@Service
@Validated
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ModelMapper modelMapper;

    public List<ManufacturerDto> findAll() {
        return mapList(manufacturerRepository.findAll(),ManufacturerDto.class);
    }

    public ManufacturerDto findById(UUID id){
        return modelMapper.map(manufacturerRepository.findById(id).orElseThrow(ManufacturerNotFoundException::new),ManufacturerDto.class);
    }

    public ManufacturerDto saveNew(@Valid ManufacturerDto manufacturerDto) {
        this.checkIfIdIsEmpty(manufacturerDto);
        return modelMapper.map(manufacturerRepository.save(modelMapper.map(manufacturerDto, Manufacturer.class)),ManufacturerDto.class);
    }

    public void deleteById(UUID id) {
        this.checkIfManufacturerExists(id);
        manufacturerRepository.deleteById(id);
    }

    private void checkIfManufacturerExists(UUID id) {
        this.findById(id);
    }

    private void checkIfIdIsEmpty(ManufacturerDto manufacturerDto) {
        if (manufacturerDto.getId() != null)
            throw new InvalidUUIDException();
    }

    public ManufacturerDto saveExisting(ManufacturerDto manufacturerDto) {
        this.checkIfManufacturerExists(manufacturerDto.getId());
        return modelMapper.map(manufacturerRepository.save(modelMapper.map(manufacturerDto, Manufacturer.class)),ManufacturerDto.class);
    }
}
