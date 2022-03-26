package com.example.finalprojectapp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @NotNull
    @Schema(description = "id manufacturer", example = "74478911-6424-47a7-911c-0daa262144fa", required = true)
    private UUID id;

    @Schema(description = "manufacturer name, max length 30", example = "SONY", required = true)
    @Column(length = 30)
    private String name;

    @Schema(description = "product description,max length 255", example = "this is the best electronics manufacturer")
    private String description;
}
