package com.example.finalprojectapp.repository;

import com.example.finalprojectapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
