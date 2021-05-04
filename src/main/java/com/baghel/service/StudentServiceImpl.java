package com.baghel.service;

import java.util.List;

import com.baghel.model.Student;

public interface StudentServiceImpl {

	Student addStudent(Student student);

	Student updateStudent(Student student);

	List<Student> getAllStudent();

	Student getStudentById(int id);

	void deleteStudent(int studentId);

}
