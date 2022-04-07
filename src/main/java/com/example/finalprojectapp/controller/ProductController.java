package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.ProductDto;
import com.example.finalprojectapp.service.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@OpenAPIDefinition(info = @Info(title = "Application Controller", description = "Rest controller", version = "1"))
@RequiredArgsConstructor
@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "GET request", description = "Get all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping
    public List<ProductDto> findAllProducts() {
        return productService.findAllProducts();
    }

    @Operation(summary = "GET request by id", description = "Get product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping("{id}")
    public ProductDto findById(@PathVariable UUID id) {
        return productService.findById(id);
    }

    @Operation(summary = "Post request body", description = "save a new product, id must be empty")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        return productService.saveNewProduct(productDto);
    }

    @Operation(summary = "Put request body", description = "save a existing product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PutMapping
    public ProductDto saveExistingProduct(@RequestBody ProductDto productDto) {
        return productService.saveExistingProduct(productDto);
    }

    @Operation(summary = "Delete by id", description = "Delete a product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByID(@PathVariable UUID id) {
        productService.deleteById(id);
    }

}
