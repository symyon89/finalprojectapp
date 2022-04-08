package com.example.finalprojectapp.config;

import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.dto.VatDto;
import com.example.finalprojectapp.model.Manufacturer;
import com.example.finalprojectapp.model.Vat;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        modelMapper.createTypeMap(Manufacturer.class, ManufacturerDto.class);
        modelMapper.createTypeMap(Vat.class, VatDto.class);
        return modelMapper;
    }
}
