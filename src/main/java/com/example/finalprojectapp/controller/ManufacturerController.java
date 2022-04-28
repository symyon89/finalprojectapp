package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.ManufacturerDto;
import com.example.finalprojectapp.service.ManufacturerService;
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
@RequestMapping("manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Operation(summary = "GET request", description = "Get all manufacturers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping
    public List<ManufacturerDto> findAll() {
        return manufacturerService.findAll();
    }

    @Operation(summary = "GET request", description = "Get manufacturer by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping("{id}")
    public ManufacturerDto findById(@PathVariable UUID id) {
        return manufacturerService.findById(id);
    }

    @Operation(summary = "Post request", description = "Save a new manufacturer ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PostMapping
    public ManufacturerDto saveNew(@RequestBody ManufacturerDto manufacturerDto) {
        return manufacturerService.saveNew(manufacturerDto);
    }

    @Operation(summary = "Put request", description = "Update manufacturer ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PutMapping
    public ManufacturerDto saveExisting(@RequestBody ManufacturerDto manufacturerDto) {
        return manufacturerService.saveExisting(manufacturerDto);
    }

    @Operation(summary = "Delete request", description = "Delete manufacturer by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable UUID id) {
        manufacturerService.deleteById(id);
    }
}
