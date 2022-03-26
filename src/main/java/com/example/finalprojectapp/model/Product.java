package com.example.finalprojectapp.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @NotNull
    @Schema(description = "id product", example = "74478911-6424-47a7-911c-0daa262144fa", required = true)
    private UUID id;

    @Schema(description = "product name,max length 30", example = "Product", required = true)
    @NotEmpty
    @Column(length = 30)
    private String name;

    @Schema(description = "product sku,max length 20", example = "PROD123")
    @Column(length = 20)
    private String sku;

    @Schema(description = "product ean,max length 13", example = "4012345678901")
    @Column(length = 13)
    private String ean;

    @Schema(description = "product description, max 255 characters", example = "This is the best product")
    private String description;

    @Schema(description = "product price, the value must 0 or positive", example = "0")
    @Min(value = 0L, message = "The value must be positive")
    private Double price;

    @Schema(description = "Manufacturer id", example = "Sony")
    @ManyToOne
    private Manufacturer manufacturer;

    @Schema(description = "product date added", example = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime dateAdded;

    @Schema(description = "last product date modified", example = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime lastDateModified;

}
