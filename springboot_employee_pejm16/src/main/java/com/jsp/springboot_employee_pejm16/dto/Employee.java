package com.jsp.springboot_employee_pejm16.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Please Enter Name")
	@NotBlank(message = "Name Can't be null")
	private String name;
	@Column(unique = true)
//	@Pattern(regexp = "[6-9][0-9]{9}",message = "Invalid Phone")	//Regular Expression Works Only For String Type Of Data
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	@NotNull(message = "Please Enter address")
	@NotBlank(message = "Please Enter address")
	private String address;
	@Min(1)
	private double salary;
	@Column(unique = true)
//	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "Invalid Email")
	@Email(regexp = "[A-Za-z0-9]+@[a-z]+\\.[in,com]{2,3}", message = "Invalid Email")
	private String email;
	private char grade;

}
