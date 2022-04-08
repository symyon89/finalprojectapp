package com.example.finalprojectapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VatDto implements Serializable {
    @Schema(description = "id Vat, if is null will create a new product", example = "1c263004-6df9-4879-a3d9-9baf22ccdc18")
    private UUID id;
    @Schema(description = "vat name,max length 12", example = "TVA-19", required = true)
    @NotEmpty
    @Length(max = 12)
    private  String name;
    @Schema(description = "vat name,max length 8", example = "19%")
    @Length(max = 8)
    private  String code;
    @Schema(description = "vat name,max length 8", example = "19", required = true)
    @NotNull
    @PositiveOrZero
    private  Double percentage;
}
