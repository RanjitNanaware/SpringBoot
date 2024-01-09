package com.jsp.springboot_student_pejm16.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private String message ;
	private int status ;
	private T data ;
	
}
