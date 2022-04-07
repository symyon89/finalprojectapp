package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.VatDto;
import com.example.finalprojectapp.service.VatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("vat")
public class VatController {
    private final VatService vatService;

    @Operation(summary = "GET request", description = "Get all vat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping
    public List<VatDto> findAll() {
        return vatService.findAll();
    }

    @Operation(summary = "GET request", description = "Get vat by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping("{id}")
    public VatDto findById(@PathVariable UUID id) {
        return vatService.findById(id);
    }

    @Operation(summary = "Post request", description = "Save a new vat ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PostMapping
    public VatDto saveNew(@RequestBody VatDto vatDto) {
        return vatService.saveNew(vatDto);
    }

    @Operation(summary = "Put request", description = "Update vat ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PutMapping
    public VatDto saveExisting(@RequestBody VatDto vatDto) {
        return vatService.saveExisting(vatDto);
    }

    @Operation(summary = "Delete request", description = "Delete vat by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable UUID id) {
        vatService.deleteById(id);
    }
}
