package com.example.finalprojectapp.repository;

import com.example.finalprojectapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
