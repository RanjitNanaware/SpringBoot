package com.jsp.springboot_employee_pejm16.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.springboot_employee_pejm16.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String Email);

	@Query("SELECT e FROM Employee e WHERE e.phone=?1")
	Employee findEmployeeByPhone(long phone);
	
	@Query("select e from Employee e where e.salary>=?1")
	List<Employee> findBySalaryGreaterThan(double salary);
	
}
