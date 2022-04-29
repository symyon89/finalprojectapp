package com.example.finalprojectapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactDto implements Serializable {
    @Schema(description = "id manufacturer", example = "74478911-6424-47a7-911c-0daa262144fa")
    private UUID id;

    @Schema(description = "boolean, true if is primary contact, only one contact can be primary", example = "true")
    private boolean primary;

    @Schema(description = "contact name, max length 40", example = "Alice", required = true)
    @NotBlank
    @NotNull
    @Length(max = 40)
    private String name;

    @Schema(description = "contact email, max length 40", example = "alice@example.com")
    @Length(max = 40)
    @Email
    private String email;

    @Schema(description = "contact phone, max length 12", example = "+40712312313")
    @Length(max = 12)
    private String phone;
}
