package com.jsp.springboot_employee_pejm16.exception;

public class AllEmployeeNotFoundException extends RuntimeException {

	String message;
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public AllEmployeeNotFoundException(String message) {
		this.message=message;
	}
	
}
