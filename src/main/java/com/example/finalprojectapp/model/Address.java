package com.example.finalprojectapp.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private boolean primaryBilling;

    private boolean primaryDelivery;

    @Column(length = 60)
    private String country;

    @Column(length = 60)
    private String county;

    @Column(length = 60)
    private String city;

    @Column(length = 60)
    private String street;

    @Column(length = 60)
    private String number;

    @Column(length = 60)
    private String otherDetails;

    @Column(length = 10)
    private String postalCode;

}
