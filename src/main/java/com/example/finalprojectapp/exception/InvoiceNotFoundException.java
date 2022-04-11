package com.example.finalprojectapp.exception;

import java.util.NoSuchElementException;

public class InvoiceNotFoundException extends NoSuchElementException {
    public InvoiceNotFoundException(){
        super("Invoice not found, check id");
    }
}
