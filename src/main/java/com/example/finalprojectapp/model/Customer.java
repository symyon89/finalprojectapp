package com.example.finalprojectapp.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @NotNull
    private UUID id;

    @Column(columnDefinition = "boolean default false")
    private boolean isActive;

    @Column(columnDefinition = "boolean default false")
    private boolean isCompany;

    @Column(length = 20)
    @NotNull
    @NotBlank
    private String name;

    @Column(length = 20)
    private String number;

    private String description;

    @OneToMany
    @JoinTable(
            name = "customer_contact",
            joinColumns =@JoinColumn(name = "customer_id"),
            inverseJoinColumns =@JoinColumn(name = "contact_id")
    )
    private List<Contact> contactList;

    @OneToMany
    @JoinTable(
            name = "customer_address",
            joinColumns =@JoinColumn(name = "customer_id"),
            inverseJoinColumns =@JoinColumn(name = "address_id")
    )
    private List<Address> addressList;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAdded;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastDateModified;

}
