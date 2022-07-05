package com.modern.process.service;

import com.modern.process.dao.EmployeeDao;
import com.modern.process.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }
}
