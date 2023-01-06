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

import com.springbootorm.entities.StudentDetails;
import com.springbootorm.exception.ResourceNotFoundException;
import com.springbootorm.repositories.OneToOneRepository;

@RestController
public class OneToOneController {

	@Autowired
	private OneToOneRepository otoRepo;

	// get all students
	@GetMapping("/students")
	public List<StudentDetails> getAllStudents() {
		return otoRepo.findAll();
	}

	// create student
	@PostMapping("/students")
	public StudentDetails createStudent(@RequestBody StudentDetails student) {
		return otoRepo.save(student);
	}

	// get student by id
	@GetMapping("/students/{id}")
	public ResponseEntity<StudentDetails> getStudentById(@PathVariable int id) {
		StudentDetails student = otoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		return ResponseEntity.ok(student);
	}

	// update student

	@PutMapping("/students/{id}")
	public ResponseEntity<StudentDetails> updateStudent(@PathVariable int id,
			@RequestBody StudentDetails studentDetails) {
		StudentDetails student = otoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

		student.setId(studentDetails.getId());
		student.setFirst_name(studentDetails.getFirst_name());
		student.setLast_name(studentDetails.getLast_name());
		student.setEmail(studentDetails.getEmail());
		student.setMobile_no(studentDetails.getMobile_no());
		student.setC_details(studentDetails.getC_details());

		StudentDetails updatedStudent = otoRepo.save(student);
		return ResponseEntity.ok(updatedStudent);
	}

	// delete student
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable int id) {
		StudentDetails student = otoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

		otoRepo.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
