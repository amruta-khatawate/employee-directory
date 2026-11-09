package com.example.employee_directory_backend.service;

import com.example.employee_directory_backend.exception.EmployeeNotFoundException;
import com.example.employee_directory_backend.model.Employee;
import com.example.employee_directory_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
       return employeeRepository.findById(id)
                .orElseThrow( () -> new EmployeeNotFoundException("Employee not found with id:" + id)
                );
    }
}
