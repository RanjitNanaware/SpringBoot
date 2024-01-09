package com.jsp.springboot_student_pejm16.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_student_pejm16.dto.Student;
import com.jsp.springboot_student_pejm16.service.StudentService;
import com.jsp.springboot_student_pejm16.util.ResponseStructure;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/saveStudent")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@GetMapping("/findStudentById")
	public ResponseEntity<ResponseStructure<Student>> findStudentById(@RequestParam int id) {
		return service.findStudentById(id);
	}

	@GetMapping("/findAllStudent")
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		return service.findAllStudent();
	}

	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}

	@PutMapping("/updateStudent")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam int id, @RequestBody Student student) {
		return service.updateStudent(id, student);
	}
	
	@PatchMapping("/updatePhone")
	public ResponseEntity<ResponseStructure<Student>> updatePhone(@RequestParam int id,@RequestParam long phone) {
		return service.updatePhone(id, phone);
	}

	@PatchMapping("/updateEmail")
	public ResponseEntity<ResponseStructure<Student>> updateEmail(@RequestParam int id,@RequestParam String email) {
		return service.updateEmail(id,email);
	}
	
	@PatchMapping("/updatePercentage")
	public ResponseEntity<ResponseStructure<Student>> updatePercentage(@RequestParam int id,@RequestParam double percentage) {
		return service.updatePercentage(id,percentage);
	}
	
	@GetMapping("/findByEmail")
	public ResponseEntity<ResponseStructure<Student>> findStudentByEmail(@RequestParam String email) {
		return service.findStudentByEmail(email);
	}
	
	@GetMapping("/findByPhone")
	public ResponseEntity<ResponseStructure<Student>> findStudentByPhone(@RequestParam long phone) {
		return service.findStudentByPhone(phone);
	}
	
	@GetMapping("/findByName")
	public ResponseEntity<ResponseStructure<Student>> findStudentByName(@RequestParam String name) {
		return service.findStudentByName(name);
	}
	
}
