package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.exception.ManufacturerNotFoudException;
import com.example.finalprojectapp.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ModelMapper modelMapper;


    public ManufacturerDto findById(UUID id){
        return modelMapper.map(manufacturerRepository.findById(id).orElseThrow(ManufacturerNotFoudException::new),ManufacturerDto.class);
    }
}
