package com.ongidideveloper.ToDoApp.controller;


import com.ongidideveloper.ToDoApp.exception.ResourceNotFoundException;
import com.ongidideveloper.ToDoApp.model.Employee;
import com.ongidideveloper.ToDoApp.repository.EmployeeRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    //GetById

    @PostMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }
    @PutMapping("edit/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable  long id,@RequestBody Employee employeeDetails){
        Employee  updateEmployee= employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailID(employeeDetails.getEmailID());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
}
