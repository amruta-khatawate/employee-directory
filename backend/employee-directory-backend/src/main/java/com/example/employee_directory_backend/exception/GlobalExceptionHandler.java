package com.example.employee_directory_backend.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.employee_directory_backend.exception.ApiErrorResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    This tells Spring that this method handles exceptions of type EmployeeNotFoundException.
//        HttpServletRequest request
//        This represents the incoming HTTP request.
//        This helps identify which API caused the error.


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(EmployeeNotFoundException ex, HttpServletRequest request){

        ApiErrorResponse response = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }


//    private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String message, String path){
//
//
//
//        return ResponseEntity.status(status).body(response);
//    }

}
