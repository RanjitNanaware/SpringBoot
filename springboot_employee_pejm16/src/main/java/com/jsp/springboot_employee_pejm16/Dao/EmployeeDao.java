package com.jsp.springboot_employee_pejm16.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_employee_pejm16.dto.Employee;
import com.jsp.springboot_employee_pejm16.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee findEmployeeById(int id) {
//		return employeeRepo.findById(id).get();

//		To Avoid NoSuchElementException
		Optional<Employee> optional = employeeRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<Employee> findAllEmployee() {
		return employeeRepo.findAll();
	}

	public Employee deleteEmployee(int id) {
		Optional<Employee> optional = employeeRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
//			1 way

//			employeeRepo.deleteById(id);
//			return optional.get();

//			2 Way

			Employee employee = optional.get();
			employeeRepo.delete(employee);
			return employee;
		}
	}

	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> optional = employeeRepo.findById(id);
		if (optional.isPresent()) {
			employee.setId(id);
			return employeeRepo.save(employee);
		}
		return null;
	}
	
	public Employee findByEmail(String email) {
		return employeeRepo.findByEmail(email);
	}

	public Employee findEmployeeByPhone(long phone) {
		return employeeRepo.findEmployeeByPhone(phone);
	}

	public List<Employee> findBySalaryGreaterThan(double salary) {
		return employeeRepo.findBySalaryGreaterThan(salary);
	}

}
