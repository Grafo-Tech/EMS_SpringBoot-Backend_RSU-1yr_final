package com.employeemanagement.springboot_backend.services;

import com.employeemanagement.springboot_backend.exception.ResourceNotFoundException;
import com.employeemanagement.springboot_backend.model.Employee;
import com.employeemanagement.springboot_backend.repositories.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Employee employee = this.employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not found! " + id));
        return ResponseEntity.ok(employee);
    }

    public ResponseEntity<Employee> UpdateById(@PathVariable Long id, @RequestBody Employee employeeDetail) {
        Employee employee = this.employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not found! " + id));

        employee.setFirstName(employeeDetail.getFirstName());
        employee.setLastName(employeeDetail.getLastName());
        employee.setEmail(employeeDetail.getEmail());
        this.employeeRepo.save(employee);
        return ResponseEntity.ok(employee);
    }
}
