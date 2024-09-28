package com.nsmaniotto.bowt.ws.exceptions;

import org.springframework.http.HttpStatus;

public class BowtException extends RuntimeException {

    private final HttpStatus status;

    public BowtException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
