package com.example.finalprojectapp.dto;

import com.example.finalprojectapp.model.Manufacturer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductDto implements Serializable {
    @Schema(description = "id product, if is null will create a new product", example = "1c263004-6df9-4879-a3d9-9baf22ccdc18")
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

    @Schema(description = "product price, the value must 0 or positive", example = "0")
    @Min(value = 0L, message = "The value must be positive")
    private  Double price;

    @Schema(description = "product quantity", example = "2")
    private Double quantity;

    @Schema(description = "Manufacturer id, if is null will not asociate a manufacturer", example = "1c263004-6df9-4879-a3d9-9baf22ccdc18")
    private UUID manufacturerID;

    @Schema(description = "product date added")
    private  LocalDateTime dateAdded;

    @Schema(description = "last product date modified")
    private LocalDateTime lastDateModified;

    public void setManufacturerID(Manufacturer manufacturer) {
        this.manufacturerID = manufacturer.getId();
    }
    public void setManufacturerID(String id) {
        if(id != null && !id.isBlank())
            this.manufacturerID = UUID.fromString(id);
    }
}
