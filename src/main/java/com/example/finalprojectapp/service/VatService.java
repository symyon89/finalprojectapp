package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.VatDto;
import com.example.finalprojectapp.exception.VatNotFoundException;
import com.example.finalprojectapp.repository.VatRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class VatService {
    private final VatRepository vatRepository;
    private final ModelMapper modelMapper;

    public VatDto findById(UUID id) {
        return modelMapper.map(vatRepository.findById(id).orElseThrow(VatNotFoundException::new),VatDto.class);
    }
}
