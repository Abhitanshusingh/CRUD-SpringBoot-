package com.baghel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baghel.exception.ResourceNotFoundException;
import com.baghel.model.Student;
import com.baghel.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceImpl {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> studentObj = this.studentRepository.findById(student.getId());
		if (studentObj.isPresent()) {
			Student studentUpdate = studentObj.get();
			studentUpdate.setId(student.getId());
			studentUpdate.setName(student.getName());
			studentUpdate.setAddress(student.getAddress());
			studentUpdate.setMobileNumber(student.getMobileNumber());
			studentRepository.save(studentUpdate);
			return (Student) studentRepository;

		} else {
			throw new ResourceNotFoundException("Record not found with id: " + student.getId());
		}
	}

	@Override
	public List<Student> getAllStudent() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int studentId) {
		Optional<Student> studentObj = this.studentRepository.findById(studentId);
		if (studentObj.isPresent()) {
			return studentObj.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id: " + studentId);
		}
	}

	@Override
	public void deleteStudent(int studentId) {
		Optional<Student> studentObj = this.studentRepository.findById(studentId);
		if (studentObj.isPresent()) {
			this.studentRepository.delete(studentObj.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id: " + studentId);
		}
	}
}
