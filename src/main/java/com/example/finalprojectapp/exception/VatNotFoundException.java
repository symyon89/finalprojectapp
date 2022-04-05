package com.example.finalprojectapp.exception;

import java.util.NoSuchElementException;

public class VatNotFoundException extends NoSuchElementException {
    public VatNotFoundException(){
        super("Vat not found, check id");
    }
}
