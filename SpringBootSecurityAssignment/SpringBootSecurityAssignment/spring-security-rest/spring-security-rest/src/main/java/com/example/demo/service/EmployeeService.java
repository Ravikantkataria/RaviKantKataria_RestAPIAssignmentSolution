package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {
	
	private java.util.List<Employee> Employees = new ArrayList<>();
	
	public Employee saveEmployee(Employee Employee) {
		this.Employees.add(Employee);
		return Employee;
	}
	
	public List<Employee> fetchAllEmployees() {
		return this.Employees;
	}
	
	public Employee fetchEmployeeByName(String name) {
		return this.Employees
						.stream()
						.filter(Employee -> Employee.getName().equalsIgnoreCase(name))
						.findAny()
						.orElseThrow();
	}
	
	public void deleteEmployeeByName(String name) {
		System.out.println("deleting Employee by name");
		this.Employees.removeIf(Employee -> Employee.getName().equalsIgnoreCase(name));
	}

}
