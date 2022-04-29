package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.AddressDto;
import com.example.finalprojectapp.model.Address;
import com.example.finalprojectapp.repository.AddressRepository;
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

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AddressControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private AddressRepository addressRepository;
    private Address address;
    @BeforeEach
    public void cleanupDatabase() {
        address = Address.builder()
                .city("brasov")
                .country("Romania")
                .county("Brasov")
                .number("22A")
                .otherDetails("Bl3")
                .primaryBilling(true)
                .primaryDelivery(true)
                .postalCode("500213")
                .street("Principal")
                .build();
        addressRepository.deleteAll();
        address = addressRepository.save(address);
    }
    @Test
    void testCRUD() throws Exception {
        AddressDto addressDto = AddressDto.builder()
                .id(address.getId())
                .city("brasov")
                .country("Romania")
                .county("Brasov")
                .number("22A")
                .otherDetails("Bl3")
                .primaryBilling(true)
                .primaryDelivery(true)
                .postalCode("500213")
                .street("Principal")
                .build();
        mvc.perform(get("/address")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(addressDto))));
        mvc.perform(put("/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addressDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(addressDto)));
        mvc.perform(get("/address/{id}",addressDto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(addressDto)));
        mvc.perform(delete("/address/{id}",addressDto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        addressDto.setId(null);
        mvc.perform(post("/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addressDto)))
                .andExpect(status().isOk());
    }

}
