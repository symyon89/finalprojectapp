package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.VatDto;
import com.example.finalprojectapp.model.Product;
import com.example.finalprojectapp.model.Vat;
import com.example.finalprojectapp.repository.ProductRepository;
import com.example.finalprojectapp.repository.VatRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class VatControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private VatRepository vatRepository;
    private Vat vat;
    @BeforeEach
    public void cleanupDatabase() {
        vat = Vat.builder()
                .name("19%")
                .code("standard")
                .percentage(19D)
                .build();
        vatRepository.deleteAll();
        vat = vatRepository.save(vat);
    }
    @Test
    void testCRUD() throws Exception {
        VatDto vatDto = VatDto.builder()
                .id(vat.getId())
                .name("19%")
                .code("standard")
                .percentage(19D)
                .build();
        mvc.perform(get("/vat")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(vatDto))));
        mvc.perform(put("/vat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vatDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(vatDto)));
        mvc.perform(get("/vat/{id}",vatDto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(vatDto)));
        mvc.perform(delete("/vat/{id}",vatDto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        vatDto.setId(null);
        mvc.perform(post("/vat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vatDto)))
                .andExpect(status().isOk());
    }
}