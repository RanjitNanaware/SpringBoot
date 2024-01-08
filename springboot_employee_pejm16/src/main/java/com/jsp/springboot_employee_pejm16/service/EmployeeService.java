package com.jsp.springboot_employee_pejm16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_employee_pejm16.Dao.EmployeeDao;
import com.jsp.springboot_employee_pejm16.dto.Employee;
import com.jsp.springboot_employee_pejm16.exception.AllEmployeeNotFoundException;
import com.jsp.springboot_employee_pejm16.exception.IdNotFoundException;
import com.jsp.springboot_employee_pejm16.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	ResponseStructure<Employee> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		double salary = employee.getSalary();
		if (salary <= 10000) {
			employee.setGrade('A');
		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('B');
		} else if (salary > 20000 && salary <= 40000) {
			employee.setGrade('C');
		} else {
			employee.setGrade('D');
		}
		structure.setMessage("Save Successfull");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmployee(employee));

		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(int id) {
		Employee employee = dao.findEmployeeById(id);
		if (employee != null) {
			structure.setMessage("Found Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Employee Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
		List<Employee> employees = dao.findAllEmployee();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();

		if (employees.isEmpty()) {
			throw new AllEmployeeNotFoundException("Employee List Empty"); 
		} else {
			structure.setMessage("Find All");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employees);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id) {
		Employee employee = dao.deleteEmployee(id);
		if (employee != null) {
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Employee Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id, Employee employee) {
		double salary = employee.getSalary();
		if (salary <= 10000) {
			employee.setGrade('A');
		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('B');
		} else if (salary > 20000 && salary <= 40000) {
			employee.setGrade('C');
		} else {
			employee.setGrade('D');
		}

		dao.updateEmployee(id, employee);

		Employee dbemployee = dao.findEmployeeById(id);

		if (dbemployee != null) {
			structure.setMessage("Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbemployee);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Employee Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id, long phone) {
		Employee employee = dao.findEmployeeById(id);
		employee.setPhone(phone);

		Employee dbemployee = dao.updateEmployee(id, employee);
		if (dbemployee != null) {
			structure.setMessage("Phone Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbemployee);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Employee Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id, String email) {
		Employee employee = dao.findEmployeeById(id);
		employee.setEmail(email);

		Employee dbemployee = dao.updateEmployee(id, employee);
		if (dbemployee != null) {
			structure.setMessage("Email Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbemployee);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Employee Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id, double salary) {
		Employee employee = dao.findEmployeeById(id);
		employee.setSalary(salary);
		if (salary <= 10000) {
			employee.setGrade('A');
		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('B');
		} else if (salary > 20000 && salary <= 40000) {
			employee.setGrade('C');
		} else {
			employee.setGrade('D');
		}

		Employee dbemployee = dao.updateEmployee(id, employee);
		if (dbemployee != null) {
			structure.setMessage("Salary Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbemployee);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Employee Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByEmail(String email) {
		Employee dbemployee = dao.findByEmail(email);
		if (dbemployee != null) {
			structure.setMessage("Fetched By Email");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbemployee);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Employee Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByPhone(long phone) {
		Employee dbemployee = dao.findEmployeeByPhone(phone);

		if (dbemployee != null) {
			structure.setMessage("Find With Phone");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbemployee);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Employee Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findBySalaryGreaterThan(double salary) {
		List<Employee> employees = dao.findBySalaryGreaterThan(salary);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();

		if (employees != null) {
			structure.setMessage("Find By Greather Than Salary");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employees);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Employee Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}

	}
}
