package com.baghel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baghel.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
