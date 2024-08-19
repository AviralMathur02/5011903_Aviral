package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Other CRUD endpoints...

    // Batch insert endpoint
    @PostMapping("/batch")
    public ResponseEntity<Void> batchInsertEmployees(@RequestBody List<Employee> employees) {
        employeeService.batchInsertEmployees(employees);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
