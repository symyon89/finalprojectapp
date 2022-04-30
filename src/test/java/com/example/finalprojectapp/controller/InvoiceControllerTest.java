package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.InvoiceDto;
import com.example.finalprojectapp.model.Invoice;
import com.example.finalprojectapp.repository.InvoiceRepository;
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
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class InvoiceControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private InvoiceRepository invoiceRepository;
    private Invoice invoice;
    @BeforeEach
    public void cleanupDatabase() {
        invoice = Invoice.builder()
                .customer(null)
                .invoiceNumber(1)
                .invoiceQuantities(new ArrayList<>())
                .dateAdded(LocalDateTime.parse("2022-04-07 10:10:10",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .lastDateModified(LocalDateTime.parse("2022-04-07 10:10:10",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
        invoiceRepository.deleteAll();
        invoice = invoiceRepository.save(invoice);

    }
    @Test
    void testCRUD() throws Exception {
        InvoiceDto invoiceDto = InvoiceDto.builder()
                .id(invoice.getId())
                .customer(null)
                .invoiceNumber(1)
                .invoiceQuantities(new ArrayList<>())
                .dateAdded(LocalDateTime.parse("2022-04-07 10:10:10",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .lastDateModified(LocalDateTime.parse("2022-04-07 10:10:10",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();

        mvc.perform(get("/invoice")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(invoiceDto))));
        mvc.perform(put("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invoiceDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(invoiceDto)));
        mvc.perform(get("/invoice/{id}",invoiceDto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(invoiceDto)));
        mvc.perform(delete("/invoice/{id}",invoiceDto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        invoiceDto.setId(null);
        mvc.perform(post("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invoiceDto)))
                .andExpect(status().isOk());
    }
}
