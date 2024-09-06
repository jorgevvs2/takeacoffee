package com.jorgevvs.TakeARest.rest;

import com.jorgevvs.TakeARest.domain.entity.Student;
import com.jorgevvs.TakeARest.domain.error.StudentErrorResponse;
import com.jorgevvs.TakeARest.domain.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student("Jorge", "Castro"));
        students.add(new Student("Mario", "Ayala"));
        students.add(new Student("Thiago", "Delphim"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/students/{student_id}")
    public Student getStudentById(@PathVariable int student_id) {

        if(student_id < 0 || student_id > students.size()) {
            throw new StudentNotFoundException("Student not found - " + student_id);
        }
        return students.get(student_id);
    }
}

