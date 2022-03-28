package com.example.finalprojectapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ManufacturerDto implements Serializable {
    @Schema(description = "id manufacturer, if is null will create a new product", example = "1c263004-6df9-4879-a3d9-9baf22ccdc18")
    private UUID id;
    @Schema(description = "manufacturer name, max length 30", example = "SONY", required = true)
    @Length(max = 30)
    private  String name;
    @Schema(description = "manufacturer description,max length 255", example = "this is the best electronics manufacturer")
    @Length(max = 255)
    private String description;
    @Schema(description = "manufacturer date added")
    private LocalDateTime dateAdded;
    @Schema(description = "last manufacturer date modified")
    private LocalDateTime lastDateModified;
}
