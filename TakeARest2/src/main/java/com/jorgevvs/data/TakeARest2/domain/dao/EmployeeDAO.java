package com.jorgevvs.data.TakeARest2.domain.dao;


import com.jorgevvs.data.TakeARest2.domain.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
