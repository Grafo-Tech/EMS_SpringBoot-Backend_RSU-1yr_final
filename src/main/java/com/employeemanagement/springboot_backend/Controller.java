package com.employeemanagement.springboot_backend;

import com.employeemanagement.springboot_backend.model.Employee;
import com.employeemanagement.springboot_backend.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class Controller {
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
    return this.employeeService.findById(id);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> UpdateById(@PathVariable Long id, @RequestBody Employee employeeDetail) {
        return this.employeeService.UpdateById(id, employeeDetail);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> DeleteById(@PathVariable Long id) {
        return this.employeeService.DeleteById(id);
    }
}
