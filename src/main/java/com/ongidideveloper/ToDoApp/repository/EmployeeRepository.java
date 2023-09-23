package com.ongidideveloper.ToDoApp.repository;

import com.ongidideveloper.ToDoApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


//Define interface
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
// database CRUD operations


}
