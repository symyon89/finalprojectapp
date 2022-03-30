package com.example.finalprojectapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
public class ContactDto implements Serializable {
    @Schema(description = "id manufacturer", example = "74478911-6424-47a7-911c-0daa262144fa", required = true)
    @NotNull
    private final UUID id;

    @Schema(description = "boolean, true if is primary contact, only one contact can be primary", example = "1")
    private final boolean isPrimary;

    @Schema(description = "contact name, max length 20", example = "Alice", required = true)
    @NotBlank
    @NotNull
    @Length(max = 20)
    private final String name;

    @Schema(description = "contact email, max length 25", example = "alice@example.com")
    @Length(max = 25)
    @Email
    private final String email;

    @Schema(description = "contact phone, max length 12", example = "+40712312313", required = true)
    @Length(max = 12)
    private final String phone;
}
