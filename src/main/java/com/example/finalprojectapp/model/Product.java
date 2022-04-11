package com.example.finalprojectapp.model;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Manufacturer manufacturer;

    @ManyToOne(cascade = CascadeType.ALL)
    private Vat vat;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAdded;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastDateModified;

}
