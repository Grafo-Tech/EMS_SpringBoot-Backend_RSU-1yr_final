package com.employeemanagement.springboot_backend.services;

import com.employeemanagement.springboot_backend.model.Employee;
import com.employeemanagement.springboot_backend.repositories.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees() {
        return this.employeeRepo.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
}
