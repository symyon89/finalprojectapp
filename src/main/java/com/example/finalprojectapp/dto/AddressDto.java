package com.example.finalprojectapp.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
public class AddressDto implements Serializable {
    @NotNull
    private final UUID id;
    private final boolean isPrimaryBilling;
    private final boolean isPrimaryDelivery;
    @Length(max = 60)
    private final String country;
    @Length(max = 60)
    private final String county;
    @Length(max = 60)
    private final String city;
    @Length(max = 60)
    private final String street;
    @Length(max = 60)
    private final String number;
    @Length(max = 60)
    private final String otherDetails;
    @Length(max = 10)
    private final String postalCode;
}
