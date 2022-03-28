package com.example.finalprojectapp.exception;

import java.util.NoSuchElementException;

public class ManufacturerNotFoudException extends NoSuchElementException {
    public ManufacturerNotFoudException() {
        super("Manufacturer not found, check id");
    }
}
