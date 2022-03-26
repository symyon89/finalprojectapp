package com.example.finalprojectapp.repository;

import com.example.finalprojectapp.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, UUID> {
}
