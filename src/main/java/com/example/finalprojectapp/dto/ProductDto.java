package com.example.finalprojectapp.dto;

import com.example.finalprojectapp.model.Manufacturer;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductDto implements Serializable {
    @NotNull
    private final UUID id;
    @NotEmpty
    private final String name;
    private final String sku;
    private final String ean;
    private final String description;
    @Min(value = 0L, message = "The value must be positive")
    private final Double price;
    private final Manufacturer manufacturer;
    private final LocalDateTime dateAdded;
    private final LocalDateTime lastDateModified;
}
