package com.huejo.spring100studies.notice.exception;

public class DuplicatedNoticeException extends RuntimeException {
    public DuplicatedNoticeException(String message) {
        super(message);
    }
}
