package com.jorgevvs.cruddemo;

import com.jorgevvs.cruddemo.domain.dao.StudentDAO;
import com.jorgevvs.cruddemo.domain.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultiplesStudents(studentDAO);
			//getAllStudents(studentDAO);
			//getStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println(studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.deleteStudent(3);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.getStudentById(1);

		student.setFirstName("Calabreso");

		studentDAO.updateStudent(student);
	}

	private void getStudentByLastName(StudentDAO studentDAO) {
		System.out.println(studentDAO.getStudentByLastName("Castro"));
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.getAllStudents();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void getStudentById(StudentDAO studentDAO) {
		Student student = new Student("Noggers", "Pietro", "jorginhovvs@gmail.com");
		studentDAO.save(student);

		int id = student.getId();

		Student readStudent = studentDAO.getStudentById(id);
		System.out.println(readStudent);
	}

	private void createMultiplesStudents(StudentDAO studentDAO) {

		Student tempStudent1 = new Student("Samylla","Mariano", "samyllala@gmail.com");
		Student tempStudent2 = new Student("Jorge","Castro", "jorg3vvs@gmail.com");
		Student tempStudent3 = new Student("Maria","Eleotério", "mariaele@gmail.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Creating multiples students");
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student");
		Student tempStudent = new Student("Luiz","da silva", "lds@gmail.com");

		studentDAO.save(tempStudent);

		System.out.println("Student created, Generated id: " + tempStudent.getId());
	}

}
