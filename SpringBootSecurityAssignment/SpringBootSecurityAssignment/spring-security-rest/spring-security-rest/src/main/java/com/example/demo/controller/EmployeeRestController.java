package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/Employees")
public class EmployeeRestController {
	
	private final EmployeeService EmployeeService;
	
	public EmployeeRestController(EmployeeService EmployeeService) {
		this.EmployeeService = EmployeeService;
	}
	
	@GetMapping
	public List<Employee> fetchAll(){
		return this.EmployeeService.fetchAllEmployees();
	}
	
	@GetMapping("/{name}")
	public Employee fetchByName(@PathVariable("name") String name){
		return this.EmployeeService.fetchEmployeeByName(name);
	}
	
	@DeleteMapping("/{name}")
	public void deleteByName(@PathVariable("name") String name){
		this.EmployeeService.deleteEmployeeByName(name);
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee Employee){
		return this.EmployeeService.saveEmployee(Employee);
	}

}
