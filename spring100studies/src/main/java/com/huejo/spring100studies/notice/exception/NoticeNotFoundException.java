package com.huejo.spring100studies.notice.exception;

public class NoticeNotFoundException extends RuntimeException {
    public NoticeNotFoundException(String message) {
        super(message);
    }
}
