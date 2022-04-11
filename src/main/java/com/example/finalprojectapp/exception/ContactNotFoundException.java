package com.example.finalprojectapp.exception;

import java.util.NoSuchElementException;

public class ContactNotFoundException extends NoSuchElementException {
    public ContactNotFoundException(){
        super("Contact not found, check id");
    }
}
