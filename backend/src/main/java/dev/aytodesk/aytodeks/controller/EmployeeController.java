package dev.aytodesk.aytodeks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.aytodesk.aytodeks.model.Employee;
import dev.aytodesk.aytodeks.service.EmployeeService;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> listAll() {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("editEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        employee.setIdEmploye(id);
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }
}
