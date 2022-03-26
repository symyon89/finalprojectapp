package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.service.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@OpenAPIDefinition(info = @Info(title = "Product Controller", description = "CRUD product controller", version = "1"))
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "product")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "GET request body", description = "Get all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "all good"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping
    public List<ProductDto> findAllProducts(){
        return productService.findAllProducts();
    }
}
