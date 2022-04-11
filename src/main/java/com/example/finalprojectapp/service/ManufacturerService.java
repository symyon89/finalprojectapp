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

    public List<ManufacturerDto> findAll() {
        return ManufacturerMapper.INSTANCE.modelToDtos(manufacturerRepository.findAll());
    }

    public ManufacturerDto findById(UUID id){
        return ManufacturerMapper.INSTANCE.modelToDto(manufacturerRepository.findById(id).orElseThrow(ManufacturerNotFoundException::new));
    }

    public ManufacturerDto saveNew(@Valid ManufacturerDto manufacturerDto) {
        this.checkIfIdIsEmpty(manufacturerDto);
        return ManufacturerMapper.INSTANCE.modelToDto(manufacturerRepository.save(ManufacturerMapper.INSTANCE.dtoToModel(manufacturerDto)));
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
        return ManufacturerMapper.INSTANCE.modelToDto(manufacturerRepository.save(ManufacturerMapper.INSTANCE.dtoToModel(manufacturerDto)));
    }
}
