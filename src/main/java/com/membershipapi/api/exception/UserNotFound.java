package com.membershipapi.api.exception;

import org.apache.catalina.User;

public class UserNotFound extends Exception{
    public UserNotFound(String user) {
        super(user + "not found exception");
    }
}

