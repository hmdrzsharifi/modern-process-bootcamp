package com.modern.process.dao;

import com.modern.process.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}