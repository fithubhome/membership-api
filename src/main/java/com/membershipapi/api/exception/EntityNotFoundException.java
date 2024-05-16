package com.membershipapi.api.exception;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String entityType) {
        super(entityType + "Not found exception");
    }
}
