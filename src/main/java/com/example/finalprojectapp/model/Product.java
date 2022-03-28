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
    private UUID id;

    @NotEmpty
    @Column(length = 30)
    private String name;

    @Column(length = 20)
    private String sku;

    @Column(length = 13)
    private String ean;

    private String description;

    @Min(value = 0L, message = "The value must be positive")
    private Double price;

    @ManyToOne
    private Manufacturer manufacturer;


    private LocalDateTime dateAdded;


    private LocalDateTime lastDateModified;

}
