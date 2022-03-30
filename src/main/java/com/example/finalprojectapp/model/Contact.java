package com.example.finalprojectapp.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

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
    private UUID id;

    @Column(columnDefinition = "boolean default false")
    private boolean isPrimary;

    @NotBlank
    @NotNull
    @Column(length = 20)
    private String name;

    @Email
    @Column(length = 25)
    private String email;

    @Column(length = 12)
    private String phone;


}
