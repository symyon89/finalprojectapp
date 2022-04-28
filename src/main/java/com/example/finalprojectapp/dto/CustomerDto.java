package com.example.finalprojectapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto implements Serializable {
    @Schema(description = "id customer", example = "74478911-6424-47a7-911c-0daa262144fa")
    private UUID id;

    @Schema(description = "boolean, true if is active,", example = "1")
    private boolean isActive;

    @Schema(description = "boolean, true if is active,", example = "1")
    private boolean isCompany;

    @Length(max = 20)
    @NotNull
    @NotBlank
    @Schema(description = "customer name, max length 20", example = "Alice", required = true)
    private String name;

    @Schema(description = "customer number, max length 20", example = "1321654654321")
    private String number;

    @Schema(description = "customer number, max length 255", example = "Discount on next delivery")
    private String description;

    @Schema(description = "list of contact persons")
    private List<ContactDto> contactList;

    @Schema(description = "list of addreses")
    private List<AddressDto> addressList;

    @Schema(description = "customer date added",pattern = "yyyy-MM-dd HH:mm:ss", example = "2022-04-28 07:35:20")
    private LocalDateTime dateAdded;

    @Schema(description = "last customer date modified",pattern = "yyyy-MM-dd HH:mm:ss", example = "2022-04-28 07:35:20")
    private LocalDateTime lastDateModified;
}
