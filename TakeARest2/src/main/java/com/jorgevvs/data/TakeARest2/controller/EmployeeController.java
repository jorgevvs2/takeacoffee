package com.jorgevvs.data.TakeARest2.controller;

import com.jorgevvs.data.TakeARest2.domain.dao.EmployeeDAO;
import com.jorgevvs.data.TakeARest2.domain.entity.Employee;
import com.jorgevvs.data.TakeARest2.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId){
        Employee temp = employeeService.findById(employeeId);

        if(temp == null){
            throw new RuntimeException("Employee not found");
        }
        employeeService.delete(temp);
        return "Employee deleted - " + employeeId;
    }
}
