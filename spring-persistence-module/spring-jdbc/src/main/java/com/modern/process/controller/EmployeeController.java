package com.modern.process.controller;

import com.modern.process.entity.Employee;
import com.modern.process.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employeeList")
    public List<Employee> getEmployee(){
        return employeeService.findAll();
    }

    @PostMapping("/createEmployee")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.insertEmployee(employee);
    }

    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee")
    public void deleteEmployee(@RequestBody Employee employee){
        employeeService.deleteEmployee(employee);
    }

}
