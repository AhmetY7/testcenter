package com.dopingtech.testcenter.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
public class ApiException {

    private final String message;
    private final HttpStatus httpStatus;
    private final Instant timestamp;

    public ApiException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = Instant.now();
    }
}
