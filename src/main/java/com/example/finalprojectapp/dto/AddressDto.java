package com.example.finalprojectapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDto implements Serializable {
    @Schema(description = "id addess", example = "74478911-6424-47a7-911c-0daa262144fa")
    private UUID id;

    @Schema(description = "boolean, true if is primary billing address, only one address can be primary", example = "1")
    private boolean isPrimaryBilling;

    @Schema(description = "boolean, true if is primary delivery address, only one address can be primary", example = "1")
    private boolean isPrimaryDelivery;

    @Schema(description = "country name, max length 60", example = "Romania", required = true)
    @Length(max = 60)
    @NotNull
    @NotBlank
    private String country;

    @Length(max = 60)
    @Schema(description = "county name, max length 60", example = "Brasov")
    private String county;

    @Schema(description = "city name, max length 60", example = "Brasov", required = true)
    @Length(max = 60)
    @NotNull
    @NotBlank
    private String city;

    @Schema(description = "street name, max length 60", example = "Principala", required = true)
    @Length(max = 60)
    @NotNull
    @NotBlank
    private String street;

    @Schema(description = "number, max length 60", example = "10C")
    @Length(max = 60)
    private String number;

    @Schema(description = "other details, max length 60", example = "bl. 10 sc A Ap 434")
    @Length(max = 60)
    private String otherDetails;

    @Schema(description = "postal code, max length 10", example = "500789")
    @Length(max = 10)
    private String postalCode;
}
