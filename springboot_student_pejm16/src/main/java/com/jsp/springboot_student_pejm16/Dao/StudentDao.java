package com.jsp.springboot_student_pejm16.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_student_pejm16.dto.Student;
import com.jsp.springboot_student_pejm16.repo.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepo repo;

	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	public Student findStudentById(int id) {
		Optional<Student> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<Student> findAllStudent() {
		return repo.findAll();
	}

	public Student deleteStudent(int id) {
		Optional<Student> optional = repo.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			Student dbstudent = optional.get();
			repo.delete(dbstudent);
			return dbstudent;
		}
	}

	public Student updateStudent(int id, Student student) {
		Optional<Student> optional = repo.findById(id);
		if (optional.isPresent()) {
			student.setId(id);
			return repo.save(student);
		}
		return null;

	}

	public Student findStudentByEmail(String email) {
		return repo.findStudentByEmail(email);
	}

	public Student findStudentByPhone(long phone) {
		return repo.findStudentByPhone(phone);
	}

	public Student findStudentByName(String name) {
		return repo.findStudentByName(name);
	}

}
