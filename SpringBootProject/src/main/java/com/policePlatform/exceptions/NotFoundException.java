package com.policePlatform.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Not found");
    }
}
