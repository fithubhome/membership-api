package com.membershipapi.api.exception;

public class EntityAllreadyExistsException extends Exception {
    public EntityAllreadyExistsException(String ex) {
        super(ex + " Entity already exists");
    }
}
