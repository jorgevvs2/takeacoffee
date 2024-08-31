package com.jorgevvs.cruddemo.domain.dao;

import com.jorgevvs.cruddemo.domain.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("from Student order by lastName", Student.class).getResultList();
    }

    @Override
    public Student getStudentByLastName(String lastName) {
        return entityManager.createQuery("from Student where lastName=:theData", Student.class).setParameter("theData", lastName).getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student deletedStudent = getStudentById(id);
        entityManager.remove(deletedStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("delete from Student").executeUpdate();
    }
}
