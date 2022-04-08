package com.example.finalprojectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDto implements Serializable {
    @NotNull
    private UUID id;
    private boolean isPrimaryBilling;
    private boolean isPrimaryDelivery;
    @Length(max = 60)
    private String country;
    @Length(max = 60)
    private String county;
    @Length(max = 60)
    private String city;
    @Length(max = 60)
    private String street;
    @Length(max = 60)
    private String number;
    @Length(max = 60)
    private String otherDetails;
    @Length(max = 10)
    private String postalCode;
}
