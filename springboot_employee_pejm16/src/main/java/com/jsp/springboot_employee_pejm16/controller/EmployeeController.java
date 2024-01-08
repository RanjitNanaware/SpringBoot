package com.jsp.springboot_employee_pejm16.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.jsp.springboot_employee_pejm16.dto.Employee;
import com.jsp.springboot_employee_pejm16.service.EmployeeService;
import com.jsp.springboot_employee_pejm16.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@ApiOperation(value = "Save Employee", notes = "this Api For save Employee data into database")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Save Successfull")})
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmploee(@Valid @RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

//	@ApiOperation(value = "Find Employee",notes = "this Api For find Employee data into database")
//	@ApiResponses(value = )
	@GetMapping("/findbyid")
	public ResponseEntity<ResponseStructure<Employee>> findEmploŪyeeById(@Valid @RequestParam int id) {
		return service.findEmployeeById(id);
	}

	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
		return service.findAllEmployee();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@Valid @PathVariable int id) {
		return service.deleteEmployee(id);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@Valid @RequestParam int id,
			@RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}

	@PatchMapping("/updatePhone")
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(@Valid @RequestParam int id,
			@Valid @RequestParam long phone) {
		return service.updatePhone(id, phone);
	}

	@PatchMapping("/updateEmail")
	public ResponseEntity<ResponseStructure<Employee>> updateEmail(@Valid @RequestParam int id,
			@Valid @RequestParam String email) {
		return service.updateEmail(id, email);
	}

	@PatchMapping("/updateSalary")
	public ResponseEntity<ResponseStructure<Employee>> updateSalary(@Valid @RequestParam int id,
			@Valid @RequestParam double salary) {
		return service.updateSalary(id, salary);
	}

	@GetMapping("/findByEmail")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByEmail(@Valid @RequestParam String email) {
		return service.findEmployeeByEmail(email);
	}

	@GetMapping("/findByPhone/{phone}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByPhone(@Valid @PathVariable long phone) {
		return service.findEmployeeByPhone(phone);
	}

	@GetMapping("/findBySalaryGreaterThan")
	public ResponseEntity<ResponseStructure<List<Employee>>> findBySalaryGreaterThan(
			@Valid @RequestParam double salary) {
		return service.findBySalaryGreaterThan(salary);
	}

//	Without Service Layer Or Business Logic

//	@Autowired
//	private EmployeeDao dao;
//
//	@PostMapping("/save")
//	public Employee saveEmploee(@RequestBody Employee employee) {
//		return dao.saveEmployee(employee);
//	}
//
//	@GetMapping("/findbyid")
//	public Employee findEmployeeById(@RequestParam int id) {
//		return dao.findEmployeeById(id);
//	}
//
//	@GetMapping("/findAll")
//	public List<Employee> findAllEmployee() {
//		return dao.findAllEmployee();
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public Employee deleteEmployee(@PathVariable int id) {
//		return dao.deleteEmployee(id);
//	}
//	
//	@PutMapping("/update")
//	public Employee updateEmployee(@RequestParam int id,@RequestBody Employee employee) {
//		return dao.updateEmployee(id, employee);
//	}

}
