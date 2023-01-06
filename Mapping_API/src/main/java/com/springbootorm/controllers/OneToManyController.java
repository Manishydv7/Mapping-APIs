package com.springbootorm.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootorm.entities.StudentOTM;
import com.springbootorm.exception.ResourceNotFoundException;
import com.springbootorm.repositories.OneToManyRepository;

@RestController
public class OneToManyController {

	@Autowired
	private OneToManyRepository otmRepo;

	// get all students
	@GetMapping("/studentsotm")
	public List<StudentOTM> getAllStudents() {
		return otmRepo.findAll();
	}

	// create student
	@PostMapping("/studentsotm")
	public StudentOTM createStudent(@RequestBody StudentOTM student) {
		return otmRepo.save(student);
	}

	// get student by id
	@GetMapping("/studentsotm/{id}")
	public ResponseEntity<StudentOTM> getStudentById(@PathVariable int id) {
		StudentOTM student = otmRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Students not exist with id :" + id));
		return ResponseEntity.ok(student);
	}

	// update student

	@PutMapping("/studentsotm/{id}")
	public ResponseEntity<StudentOTM> updateStudent(@PathVariable int id, @RequestBody StudentOTM studentOTM) {
		StudentOTM student = otmRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

		student.setS_id(studentOTM.getS_id());
		student.setS_name(studentOTM.getS_name());
		student.setEmail(studentOTM.getEmail());
		student.setLaptops(studentOTM.getLaptops());

		StudentOTM updatedStudent = otmRepo.save(student);
		return ResponseEntity.ok(updatedStudent);
	}

	// delete student
	@DeleteMapping("/studentsotm/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable int id) {
		StudentOTM student = otmRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

		otmRepo.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
