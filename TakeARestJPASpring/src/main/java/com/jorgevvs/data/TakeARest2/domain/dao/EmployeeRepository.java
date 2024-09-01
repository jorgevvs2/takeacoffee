package com.jorgevvs.data.TakeARest2.domain.dao;

import com.jorgevvs.data.TakeARest2.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
