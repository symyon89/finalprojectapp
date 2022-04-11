package com.example.finalprojectapp.exception;

import java.util.NoSuchElementException;

public class AddressNotFoundException extends NoSuchElementException {
    public AddressNotFoundException(){
        super("Address not found, check id");
    }
}
