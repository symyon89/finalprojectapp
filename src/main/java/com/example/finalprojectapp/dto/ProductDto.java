package com.example.finalprojectapp.dto;

import com.example.finalprojectapp.model.Manufacturer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductDto implements Serializable {
    @Schema(description = "id product", example = "74478911-6424-47a7-911c-0daa262144fa", required = true)
    @NotNull
    private final UUID id;

    @Schema(description = "product name,max length 30", example = "Product", required = true)
    @NotEmpty
    @Length(max = 30)
    private final String name;

    @Schema(description = "product sku,max length 20", example = "PROD123")
    @Length(max = 20)
    private final String sku;

    @Schema(description = "product ean,max length 13", example = "4012345678901")
    @Length(max = 13)
    private final String ean;

    @Schema(description = "product description, max 255 characters", example = "This is the best product")
    @Length(max = 255)
    private final String description;

    @Schema(description = "product price, the value must 0 or positive", example = "0")
    @Min(value = 0L, message = "The value must be positive")
    private final Double price;

    @Schema(description = "Manufacturer id", example = "74478911-6424-47a7-911c-0daa262144fa")
    private UUID manufacturerID;

    @Schema(description = "product date added", example = "yyyy/MM/dd HH:mm:ss")
    private final LocalDateTime dateAdded;

    @Schema(description = "last product date modified", example = "yyyy/MM/dd HH:mm:ss")
    private final LocalDateTime lastDateModified;

    public void setManufacturerID(Manufacturer manufacturer) {
        this.manufacturerID = manufacturer.getId();
    }
    public void setManufacturerID(String id) {
        if(!id.isBlank())
            this.manufacturerID = UUID.fromString(id);
    }
}
