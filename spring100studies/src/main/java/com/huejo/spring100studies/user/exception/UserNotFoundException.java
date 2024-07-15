package com.huejo.spring100studies.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
