package com.example.finalprojectapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ManufacturerDto implements Serializable {
    @Schema(description = "id manufacturer", example = "74478911-6424-47a7-911c-0daa262144fa", required = true)
    @NotNull
    private final UUID id;
    @Schema(description = "manufacturer name, max length 30", example = "SONY", required = true)
    @Length(max = 30)
    private final String name;
    @Schema(description = "manufacturer description,max length 255", example = "this is the best electronics manufacturer")
    @Length(max = 255)
    private final String description;
    @Schema(description = "manufacturer date added", example = "yyyy/MM/dd HH:mm:ss")
    private final LocalDateTime dateAdded;
    @Schema(description = "last manufacturer date modified", example = "yyyy/MM/dd HH:mm:ss")
    private final LocalDateTime lastDateModified;
}
