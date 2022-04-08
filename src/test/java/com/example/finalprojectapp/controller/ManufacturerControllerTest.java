package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.model.Manufacturer;
import com.example.finalprojectapp.repository.ManufacturerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ManufacturerControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    private Manufacturer manufacturer;
    @BeforeEach
    public void cleanupDatabase() {
        manufacturer = Manufacturer.builder()
                .description("China Manufacturer")
                .name("Chinese name")
                .dateAdded(LocalDateTime.parse("2022-04-07 10:10:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .lastDateModified(LocalDateTime.parse("2022-04-07 10:10:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
        manufacturerRepository.deleteAll();
        manufacturer = manufacturerRepository.save(manufacturer);
    }
    @Test
    void testCRUD() throws Exception {
        ManufacturerDto manufacturerDto = ManufacturerDto.builder()
                .id(manufacturer.getId())
                .description("China Manufacturer")
                .name("Chinese name")
                .dateAdded(LocalDateTime.parse("2022-04-07 10:10:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .lastDateModified(LocalDateTime.parse("2022-04-07 10:10:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
        mvc.perform(get("/manufacturer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(manufacturerDto))));
        mvc.perform(put("/manufacturer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(manufacturerDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(manufacturerDto)));
        mvc.perform(get("/manufacturer/{id}",manufacturerDto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(manufacturerDto)));
        mvc.perform(delete("/manufacturer/{id}",manufacturerDto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        manufacturerDto.setId(null);
        mvc.perform(post("/manufacturer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(manufacturerDto)))
                .andExpect(status().isOk());
    }
}