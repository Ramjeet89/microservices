package com.employee.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;

@RestController
public class TestController {

	@GetMapping("/employee")
	public Employee firstPage() {
		Employee emp = new Employee();
		emp.setEmpId("101");
		emp.setName("Ramjeet");
		emp.setDesignation("APSA");
		emp.setSalary(50000);
		return emp;
	}
}
