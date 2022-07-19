package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {
	
	private final StudentService studentService;
	
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<Student> fetchAll(){
		return this.studentService.fetchAllStudents();
	}
	
	@GetMapping("/{name}")
	public Student fetchByName(@PathVariable("name") String name){
		return this.studentService.fetchStudentByName(name);
	}
	
	@DeleteMapping("/{name}")
	public void deleteByName(@PathVariable("name") String name){
		this.studentService.deleteStudentByName(name);
	}
	
	@PostMapping
	public Student saveStudent(@RequestBody Student student){
		return this.studentService.saveStudent(student);
	}

}
