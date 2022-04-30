package com.example.finalprojectapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class InvoiceQuantityDto implements Serializable {
    @Schema(description = "id invice quanttity", example = "74478911-6424-47a7-911c-0daa262144fa")
    private final UUID id;
    @Schema(description = "Product object, if is null will not associated a customer")
    private final ProductDto product;
    @Schema(description = "Quantity", example = "1")
    private final Integer quantity;
}
