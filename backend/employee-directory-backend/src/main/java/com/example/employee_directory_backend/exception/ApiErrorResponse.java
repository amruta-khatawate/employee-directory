package com.example.employee_directory_backend.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiErrorResponse {

    private LocalDateTime timeStamp;
    private int status;
    private String message;
    private String path;

    public ApiErrorResponse(LocalDateTime now, int httpStatus, String message, String requestURI) {

        this.timeStamp = now;
        this.status = httpStatus;
        this.message = message;
        this.path = requestURI;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
