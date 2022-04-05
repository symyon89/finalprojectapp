package com.example.finalprojectapp.exception;

import java.util.NoSuchElementException;

public class ProductNotFoundException extends NoSuchElementException {
    public ProductNotFoundException() {
        super("Product not found , check id");
    }

}
