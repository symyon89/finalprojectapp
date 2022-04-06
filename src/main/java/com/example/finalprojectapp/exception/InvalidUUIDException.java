package com.example.finalprojectapp.exception;

public class InvalidUUIDException extends RuntimeException {
    public InvalidUUIDException() {
        super("UUID is invalid");
    }
}
