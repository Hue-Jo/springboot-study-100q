package com.huejo.spring100studies.user.exception;

public class ExistsEmailException extends RuntimeException {
    public ExistsEmailException(String s) {
        super(s);
    }
}
