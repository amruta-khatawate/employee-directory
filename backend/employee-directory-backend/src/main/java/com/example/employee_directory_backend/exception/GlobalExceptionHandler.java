package com.example.employee_directory_backend.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.employee_directory_backend.exception.ApiErrorResponse;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDate;
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

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ApiErrorResponse> handleDuplicateEmail(DuplicateEmailException ex , HttpServletRequest request){

        ApiErrorResponse response = new ApiErrorResponse(

                LocalDateTime.now(),
                HttpStatus.NOT_ACCEPTABLE.value(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

//    This occurs when the request body is readable, but fails Bean validation rules such as @NotBlank or @Email.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex){

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Invalid request data");

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

//    This occurs when a URL parameter has an incompatible data type.
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex){
        String message = "Invalid value for parameter";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    //this occurs when URL is not valid for example hitting employees/46 instead of employee/46
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> handleNoResoruce(NoResourceFoundException ex){
        String message = "Invalid URL";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

//    This occurs when Spring cannot read or convert the request body into your Java object.
//    for example incomplete Json body and missing json fields
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessage(HttpMessageNotReadableException ex){
        String message = "Invalid request body. Please provide valid JSON.";


        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleExeptions(Exception ex){
//        String message = "Unexpected server errors.";
//        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String message, String path){
//
//
//
//        return ResponseEntity.status(status).body(response);
//    }

}
