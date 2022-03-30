package com.example.finalprojectapp.exception;

import java.util.NoSuchElementException;

public class ManufacturerNotFoundException extends NoSuchElementException {
    public ManufacturerNotFoundException() {
        super("Manufacturer not found, check id");
    }
}
