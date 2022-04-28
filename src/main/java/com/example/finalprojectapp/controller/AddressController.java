package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.AddressDto;
import com.example.finalprojectapp.service.AddressService;
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
@RequestMapping("address")
public class AddressController {
    private final AddressService addressService;

    @Operation(summary = "GET request", description = "Get all addresses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @Operation(summary = "GET request", description = "Get address by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping("{id}")
    public AddressDto findById(@PathVariable UUID id) {
        return addressService.findById(id);
    }

    @Operation(summary = "Post request", description = "Save a new address ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PostMapping
    public AddressDto saveNew(@RequestBody AddressDto addressDto) {
        return addressService.saveNew(addressDto);
    }

    @Operation(summary = "Put request", description = "Update address ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PutMapping
    public AddressDto saveExisting(@RequestBody AddressDto addressDto) {
        return addressService.saveExisting(addressDto);
    }

    @Operation(summary = "Delete request", description = "Delete address by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable UUID id) {
        addressService.deleteById(id);
    }
}
