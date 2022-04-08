package com.example.finalprojectapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {
    @Schema(description = "id product", example = "1c263004-6df9-4879-a3d9-9baf22ccdc18")
    private UUID id;

    @Schema(description = "product name,max length 30", example = "Product", required = true)
    @NotEmpty
    @Length(max = 30)
    private String name;

    @Schema(description = "product sku,max length 20", example = "PROD123")
    @Length(max = 20)
    private String sku;

    @Schema(description = "product ean,max length 13", example = "4012345678901")
    @Length(max = 13)
    private String ean;

    @Schema(description = "product description, max 255 characters", example = "This is the best product")
    @Length(max = 255)
    private String description;

    @Schema(description = "product price, the value must be 0 or positive", example = "0")
    @Min(value = 0L, message = "The value must be positive")
    private  Double price;

    @Schema(description = "price with Vat", example = "0")
    private Double priceWithVat;

    @Schema(description = "product quantity", example = "2")
    private Double quantity;

    @Schema(description = "Manufacturer id, if is null will not associated a manufacturer", example = "1c263004-6df9-4879-a3d9-9baf22ccdc18")
    private ManufacturerDto manufacturerDto;

    @Schema(description = "Vat id, if is null will not associated a vat, and price with vat will be without added value", example = "1c263004-6df9-4879-a3d9-9baf22ccdc18")
    private VatDto vatDto;

    @Schema(description = "product date added",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  LocalDateTime dateAdded;

    @Schema(description = "last product date modified",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastDateModified;

}
