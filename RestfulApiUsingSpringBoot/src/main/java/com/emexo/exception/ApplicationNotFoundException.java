package com.emexo.exception;

public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException(String exception) {
        super(exception);
    }
}
