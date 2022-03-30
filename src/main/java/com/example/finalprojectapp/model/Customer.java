package com.example.finalprojectapp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    @Schema(description = "id customer", example = "74478911-6424-47a7-911c-0daa262144fa")
    private UUID id;

    @Schema(description = "boolean, true if is active,", example = "1")
    @Column(columnDefinition = "boolean default false")
    private boolean isActive;

    @Schema(description = "boolean, true if is active,", example = "1")
    @Column(columnDefinition = "boolean default false")
    private boolean isCompany;

    @Schema(description = "customer name, max length 20", example = "Alice", required = true)
    @Column(length = 20)
    @NotNull
    @NotBlank
    private String name;

    @Schema(description = "customer number, max length 20", example = "1321654654321")
    @Column(length = 20)
    private String number;

    @Schema(description = "customer number, max length 255", example = "Discount on next delivery")
    private String description;

    @Schema(description = "list of contact persons")
    @OneToMany
    @JoinColumn
    private List<Contact> contactList;

    @Schema(description = "list of addreses")
    @OneToMany
    @JoinColumn
    private List<Address> addressList;

    @Schema(description = "customer date added", example = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime dateAdded;

    @Schema(description = "last customer date modified", example = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime lastDateModified;

}
