package com.jsp.springboot_student_pejm16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_student_pejm16.Dao.StudentDao;
import com.jsp.springboot_student_pejm16.dto.Student;
import com.jsp.springboot_student_pejm16.util.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	ResponseStructure<Student> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		double percentage = student.getPercentage();
		if (percentage >= 65) {
			student.setGrade("Distinction");
		} else if (percentage > 60 && percentage <= 85) {
			student.setGrade("First Class");
		} else if (percentage > 49 && percentage <= 60) {
			student.setGrade("Second Class");
		} else if (percentage >= 35 && percentage <= 49) {
			student.setGrade("Pass");
		} else {
			student.setGrade("Fail");
		}
		structure.setMessage("Save Successfull");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveStudent(student));

		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Student>> findStudentById(int id) {
		Student student = dao.findStudentById(id);
		if (student != null) {
			structure.setMessage("Found Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		List<Student> students = dao.findAllStudent();
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();

		if (students.isEmpty()) {
			structure.setMessage("Not Data Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		} else {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(students);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {
		Student student = dao.deleteStudent(id);
		if (student != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Not Data Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(int id, Student student) {
		Student dbstudent = dao.findStudentById(id);

		double percentage = student.getPercentage();
		if (dbstudent != null) {

			if (percentage >= 65) {
				student.setGrade("Distinction");
			} else if (percentage > 60 && percentage <= 85) {
				student.setGrade("First Class");
			} else if (percentage > 49 && percentage <= 60) {
				student.setGrade("Second Class");
			} else if (percentage >= 35 && percentage <= 49) {
				student.setGrade("Pass");
			} else {
				student.setGrade("Fail");
			}
		}
		dao.updateStudent(id, student);

		if (dbstudent != null) {
			structure.setMessage("Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbstudent);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Employee Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updatePhone(int id, long phone) {
		Student student = dao.findStudentById(id);
		student.setPhone(phone);

		Student dbstudent = dao.updateStudent(id, student);

		if (dbstudent != null) {
			structure.setMessage("Phone Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbstudent);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Phone Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Student>> updateEmail(int id, String email) {
		Student student = dao.findStudentById(id);
		student.setEmail(email);

		Student dbstudent = dao.updateStudent(id, student);

		if (dbstudent != null) {
			structure.setMessage("Email Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbstudent);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Email Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updatePercentage(int id, double percentage) {
		Student student = dao.findStudentById(id);
		student.setPercentage(percentage);
		if (student != null) {
			double percentage2 = student.getPercentage();
			if (percentage2 >= 65) {
				student.setGrade("Distinction");
			} else if (percentage2 > 60 && percentage2 <= 85) {
				student.setGrade("First Class");
			} else if (percentage2 > 49 && percentage2 <= 60) {
				student.setGrade("Second Class");
			} else if (percentage2 >= 35 && percentage2 <= 49) {
				student.setGrade("Pass");
			} else {
				student.setGrade("Fail");
			}
		}

		Student dbstudent = dao.updateStudent(id, student);

		if (dbstudent != null) {
			structure.setMessage("percentage Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbstudent);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Student>> findStudentByEmail(String email) {
		Student dbstudent = dao.findStudentByEmail(email);

		if (dbstudent != null) {
			structure.setMessage("Email found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbstudent);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Email Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Student>> findStudentByPhone(long phone) {
		Student dbstudent = dao.findStudentByPhone(phone);
		
		if (dbstudent != null) {
			structure.setMessage("Phone Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbstudent);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Phone Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Student>> findStudentByName(String name) {
		Student dbstudent = dao.findStudentByName(name);
		
		if (dbstudent != null) {
			structure.setMessage("Name Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbstudent);

			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
			structure.setMessage("Name Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);

			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}
	}

}
