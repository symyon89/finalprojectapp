package com.example.finalprojectapp.repository;

import com.example.finalprojectapp.model.Vat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VatRepository extends JpaRepository<Vat, UUID> {
}
