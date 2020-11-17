package com.accessment.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private final HttpStatus httpStatus;
    private final String stackTrace;
    private String origin;
    private String timestamp;

    public ErrorResponse(HttpStatus httpStatus, Exception ex) {
        this.httpStatus = httpStatus;
        this.stackTrace = ex.getMessage();
        this.origin = ex.getClass().getSimpleName();
        this.timestamp = LocalDateTime.now().toString();
    }
}
