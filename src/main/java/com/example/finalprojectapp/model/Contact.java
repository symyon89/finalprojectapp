package com.example.finalprojectapp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @NotNull
    @Schema(description = "id manufacturer", example = "74478911-6424-47a7-911c-0daa262144fa", required = true)
    private UUID id;

    @Schema(description = "contact name, max length 20", example = "Alice", required = true)
    @NotBlank
    @Column(length = 20)
    private String name;

    @Schema(description = "contact email, max length 25", example = "alice@example.com")
    @Email
    @Column(length = 25)
    private String email;

    @Schema(description = "contact email, max length 12", example = "+40712312313", required = true)
    @Column(length = 12)
    private String phone;
}
