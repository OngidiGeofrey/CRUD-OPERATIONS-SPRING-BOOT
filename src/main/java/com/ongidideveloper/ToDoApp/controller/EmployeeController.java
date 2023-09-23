package com.ongidideveloper.ToDoApp.controller;


import com.ongidideveloper.ToDoApp.model.Employee;
import com.ongidideveloper.ToDoApp.repository.EmployeeRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Listing
    @GetMapping("listing")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    //create
    @PostMapping("create")
    public Employee create(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
}
