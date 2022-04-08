package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.VatDto;
import com.example.finalprojectapp.exception.InvalidUUIDException;
import com.example.finalprojectapp.exception.VatNotFoundException;
import com.example.finalprojectapp.model.Vat;
import com.example.finalprojectapp.repository.VatRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static com.example.finalprojectapp.config.GenericListMapper.mapList;

@Service
@RequiredArgsConstructor
@Validated
public class VatService {
    private final VatRepository vatRepository;
    private final ModelMapper modelMapper;


    public List<VatDto> findAll() {
        return mapList(vatRepository.findAll(), VatDto.class);
    }

    public VatDto findById(UUID id) {
        return modelMapper.map(vatRepository.findById(id).orElseThrow(VatNotFoundException::new),VatDto.class);
    }

    public VatDto saveNew(@Valid VatDto vatDto) {
        this.checkIfIdIsEmpty(vatDto);
        return modelMapper.map(vatRepository.save(modelMapper.map(vatDto, Vat.class)),VatDto.class);
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
        return modelMapper.map(vatRepository.save(modelMapper.map(vatDto, Vat.class)),VatDto.class);
    }
}
