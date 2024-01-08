package com.jsp.springboot_employee_pejm16.exception;

public class IdNotFoundException extends RuntimeException {

	String message;

	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFoundException(String message) {
		this.message = message;
	}

}
