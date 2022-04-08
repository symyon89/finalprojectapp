package com.example.finalprojectapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class CustomerDto implements Serializable {
    @Schema(description = "id customer", example = "74478911-6424-47a7-911c-0daa262144fa")
    private final UUID id;

    @Schema(description = "boolean, true if is active,", example = "1")
    private final boolean isActive;

    @Schema(description = "boolean, true if is active,", example = "1")
    private final boolean isCompany;

    @Length(max = 20)
    @NotNull
    @NotBlank
    @Schema(description = "customer name, max length 20", example = "Alice", required = true)
    private final String name;

    @Schema(description = "customer number, max length 20", example = "1321654654321")
    private final String number;

    @Schema(description = "customer number, max length 255", example = "Discount on next delivery")
    private final String description;

    @Schema(description = "list of contact persons")
    private final List<ContactDto> contactList;

    @Schema(description = "list of addreses")
    private final List<AddressDto> addressList;

    @Schema(description = "customer date added",pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime dateAdded;

    @Schema(description = "last customer date modified",pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime lastDateModified;
}
