package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.exception.InvalidUUIDException;
import com.example.finalprojectapp.exception.ManufacturerNotFoundException;
import com.example.finalprojectapp.mapper.ManufacturerMapper;
import com.example.finalprojectapp.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
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
    private final ManufacturerMapper manufacturerMapper;

    public List<ManufacturerDto> findAll() {
        return manufacturerMapper.modelToDtos(manufacturerRepository.findAll());
    }

    public ManufacturerDto findById(UUID id){
        return manufacturerMapper.modelToDto(manufacturerRepository.findById(id).orElseThrow(ManufacturerNotFoundException::new));
    }

    public ManufacturerDto saveNew(@Valid ManufacturerDto manufacturerDto) {
        this.checkIfIdIsEmpty(manufacturerDto);
        return manufacturerMapper.modelToDto(manufacturerRepository.save(manufacturerMapper.dtoToModel(manufacturerDto)));
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
        return manufacturerMapper.modelToDto(manufacturerRepository.save(manufacturerMapper.dtoToModel(manufacturerDto)));
    }
}
