package com.example.employee_directory_backend.controller;

import com.example.employee_directory_backend.model.Employee;
import com.example.employee_directory_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable int id){
        employeeService.deleteEmployeeById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.createEmployee(employee);

        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }
}
