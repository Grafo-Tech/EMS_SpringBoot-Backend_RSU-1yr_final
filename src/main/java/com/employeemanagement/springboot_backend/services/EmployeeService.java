package com.employeemanagement.springboot_backend.services;

import com.employeemanagement.springboot_backend.model.Employee;
import com.employeemanagement.springboot_backend.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = employeeRepo.findAll();
        return employeeList;
    }
}
