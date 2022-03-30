package com.example.finalprojectapp.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
    private UUID id;

    @NotNull
    @NotBlank
    @Column(length = 30)
    private String name;

    @Column(length = 20)
    private String sku;

    @Column(length = 13)
    private String ean;

    private String description;

    @Min(value = 0L, message = "The value must be positive")
    private Double price;

    private Double quantity;

    @ManyToOne
    private Manufacturer manufacturer;

    private LocalDateTime dateAdded;

    private LocalDateTime lastDateModified;

}
