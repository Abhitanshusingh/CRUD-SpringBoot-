package com.baghel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baghel.model.Student;
import com.baghel.service.StudentService;

@RestController()
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudent() {
		return ResponseEntity.ok().body(studentService.getAllStudent());
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		return ResponseEntity.ok().body(studentService.getStudentById(id));
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return ResponseEntity.ok().body(studentService.addStudent(student));
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student student){
		student.setId(id);
		return ResponseEntity.ok().body(studentService.updateStudent(student));
	}
	
	@DeleteMapping("/student/{id}")
	public HttpStatus deleteStudent(@PathVariable int id){
		studentService.deleteStudent(id);
		return HttpStatus.OK ;
		
	}
}
