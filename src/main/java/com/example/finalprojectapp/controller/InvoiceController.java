package com.example.finalprojectapp.controller;

import com.example.finalprojectapp.dto.InvoiceDto;
import com.example.finalprojectapp.service.InvoiceService;
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
@RequestMapping("invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Operation(summary = "GET request", description = "Get all invoices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping
    public List<InvoiceDto> findAll() {
        return invoiceService.findAll();
    }

    @Operation(summary = "GET request", description = "Get invoice by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping("{id}")
    public InvoiceDto findById(@PathVariable UUID id) {
        return invoiceService.findById(id);
    }

    @Operation(summary = "Post request", description = "Save a new invoice ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PostMapping
    public InvoiceDto saveNew(@RequestBody InvoiceDto invoiceDto) {
        return invoiceService.saveNew(invoiceDto);
    }

    @Operation(summary = "Put request", description = "Update manufacturer ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PutMapping
    public InvoiceDto saveExisting(@RequestBody InvoiceDto invoiceDto) {
        return invoiceService.saveExisting(invoiceDto);
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
        invoiceService.deleteById(id);
    }
}
