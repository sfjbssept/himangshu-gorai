package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.repo.IStudentRepository;

@RestController
public class StudentController {

	@Autowired
	private IStudentRepository studentRepository;

	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student addedStudent = this.studentRepository.save(student);
		return ResponseEntity.ok(addedStudent);

	}

	@GetMapping("/students")
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok(this.studentRepository.findAll());

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
		Student updatedStudent = this.studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);

	}

}
