package com.jsp.springboot_student_pejm16.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.springboot_student_pejm16.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	Student findStudentByEmail(String email);

	@Query("select s from Student s where s.phone=?1")
	Student findStudentByPhone(long phone);

	@Query("select s from Student s where s.name=?1")
	Student findStudentByName(String name);

}
