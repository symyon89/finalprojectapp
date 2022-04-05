package com.example.finalprojectapp.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
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

    @PositiveOrZero(message = "The value must be positive")
    private Double price;

    private Double quantity;

    @ManyToOne
    private Manufacturer manufacturer;

    @ManyToOne
    private Vat vat;

    private LocalDateTime dateAdded;

    private LocalDateTime lastDateModified;

}
