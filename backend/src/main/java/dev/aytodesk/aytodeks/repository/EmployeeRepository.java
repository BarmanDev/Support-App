package dev.aytodesk.aytodeks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aytodesk.aytodeks.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
