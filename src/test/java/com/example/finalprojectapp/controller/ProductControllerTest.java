package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.model.Product;
import com.example.finalprojectapp.repository.ProductRepository;
import com.example.finalprojectapp.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    private Product product;
    @BeforeEach
    public void cleanupDatabase() {
        product = Product.builder()
                .name("LG")
                .sku("5554")
                .ean("1234567891011")
                .description("best product")
                .price(2.33)
                .quantity(10D)
                .dateAdded(LocalDateTime.parse("2022-04-07 10:10:10",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .lastDateModified(LocalDateTime.parse("2022-04-07 10:10:10",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
        productRepository.deleteAll();
        product = productRepository.save(product);
    }

    @Test
    void testCRUD() throws Exception {
        ProductDto productDto = ProductDto.builder()
                .id(product.getId())
                .name("LG")
                .sku("5554")
                .ean("1234567891011")
                .description("best product")
                .price(2.33)
                .priceWithVat(2.33)
                .quantity(10D)
                .dateAdded(LocalDateTime.parse("2022-04-07 10:10:10",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .lastDateModified(LocalDateTime.parse("2022-04-07 10:10:10",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
        mvc.perform(get("/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(productDto))));
        mvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productDto)));
        mvc.perform(get("/product/{id}",product.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productDto)));
        mvc.perform(delete("/product/{id}",product.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}