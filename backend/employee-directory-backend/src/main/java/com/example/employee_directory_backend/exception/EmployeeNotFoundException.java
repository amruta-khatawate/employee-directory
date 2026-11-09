package com.example.employee_directory_backend.exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
