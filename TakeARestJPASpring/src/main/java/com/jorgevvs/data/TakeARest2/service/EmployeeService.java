package com.jorgevvs.data.TakeARest2.service;

import com.jorgevvs.data.TakeARest2.domain.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(int id);
    Employee save(Employee employee);
    void delete(Employee employee);
}
