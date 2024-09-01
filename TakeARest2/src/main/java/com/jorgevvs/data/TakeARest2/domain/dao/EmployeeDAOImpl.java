package com.jorgevvs.data.TakeARest2.domain.dao;

import com.jorgevvs.data.TakeARest2.domain.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        return em.createQuery("FROM Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return em.merge(employee);
    }


    @Override
    public void deleteEmployee(Employee employee) {
        em.remove(findById(employee.getId()));
    }
}
