package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.VatDto;
import com.example.finalprojectapp.exception.InvalidUUIDException;
import com.example.finalprojectapp.exception.VatNotFoundException;
import com.example.finalprojectapp.mapper.VatMapper;
import com.example.finalprojectapp.repository.VatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Validated
public class VatService {
    private final VatRepository vatRepository;
    private final VatMapper vatMapper;



    public List<VatDto> findAll() {
        return vatMapper.modelToDtos(vatRepository.findAll());
    }

    public VatDto findById(UUID id) {
        return vatMapper.modelToDto(vatRepository.findById(id).orElseThrow(VatNotFoundException::new));
    }

    public VatDto saveNew(@Valid VatDto vatDto) {
        this.checkIfIdIsEmpty(vatDto);
        return vatMapper.modelToDto(vatRepository.save(vatMapper.dtoToModel(vatDto)));
    }

    public void deleteById(UUID id) {
        this.checkIfVatExists(id);
        vatRepository.deleteById(id);
    }

    private void checkIfVatExists(UUID id) {
        this.findById(id);
    }

    private void checkIfIdIsEmpty(VatDto vatDto) {
        if (vatDto.getId() != null)
            throw new InvalidUUIDException();
    }

    public VatDto saveExisting(VatDto vatDto) {
        this.checkIfVatExists(vatDto.getId());
        return vatMapper.modelToDto(vatRepository.save(vatMapper.dtoToModel(vatDto)));
    }
}
