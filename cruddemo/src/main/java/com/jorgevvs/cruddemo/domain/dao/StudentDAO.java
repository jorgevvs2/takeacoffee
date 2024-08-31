package com.jorgevvs.cruddemo.domain.dao;

import com.jorgevvs.cruddemo.domain.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    Student getStudentByLastName(String lastName);
    void updateStudent(Student student);
    void deleteStudent(int id);
    int deleteAll();
}
