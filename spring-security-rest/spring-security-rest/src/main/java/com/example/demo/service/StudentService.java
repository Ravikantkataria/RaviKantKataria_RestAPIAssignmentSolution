package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Student;

@Service
public class StudentService {
	
	private java.util.List<Student> students = new ArrayList<>();
	
	public Student saveStudent(Student student) {
		this.students.add(student);
		return student;
	}
	
	public List<Student> fetchAllStudents() {
		return this.students;
	}
	
	public Student fetchStudentByName(String name) {
		return this.students
						.stream()
						.filter(student -> student.getName().equalsIgnoreCase(name))
						.findAny()
						.orElseThrow();
	}
	
	public void deleteStudentByName(String name) {
		System.out.println("deleting student by name");
		this.students.removeIf(student -> student.getName().equalsIgnoreCase(name));
	}

}
