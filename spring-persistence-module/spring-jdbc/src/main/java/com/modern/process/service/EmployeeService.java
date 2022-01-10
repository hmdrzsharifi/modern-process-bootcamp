package com.modern.process.service;

import com.modern.process.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
