package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.CustomerDto;
import com.example.finalprojectapp.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "${allowed.origins}")
@RequiredArgsConstructor
@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    @Operation(summary = "GET request", description = "Get all customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping
    public List<CustomerDto> findAllProducts() {
        return customerService.findAllProducts();
    }

    @Operation(summary = "GET request by id", description = "Get customer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping("{id}")
    public CustomerDto findById(@PathVariable UUID id) {
        return customerService.findById(id);
    }

    @Operation(summary = "Post request body", description = "save a new customer, id must be empty")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PostMapping
    public CustomerDto saveNewProduct(@RequestBody CustomerDto customerDto) {
        return customerService.saveNewProduct(customerDto);
    }

    @Operation(summary = "Put request body", description = "save a existing customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PutMapping
    public CustomerDto saveExistingProduct(@RequestBody CustomerDto customerDto) {
        return customerService.saveExistingProduct(customerDto);
    }

    @Operation(summary = "Delete by id", description = "Delete a customer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByID(@PathVariable UUID id) {
        customerService.deleteById(id);
    }
}
