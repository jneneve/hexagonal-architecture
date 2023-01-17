package com.example.demo.employee.adapter.in.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employee.application.port.in.CreateEmployee;
import com.example.demo.employee.application.port.in.GetEmployeesByJob;
import com.example.demo.employee.domain.Employee;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	private final GetEmployeesByJob getEmployeesByJob;

	private final CreateEmployee createEmployee;

	@Autowired
	public EmployeeController(GetEmployeesByJob getEmployeesByJob, CreateEmployee createEmployee) {
		this.getEmployeesByJob = getEmployeesByJob;
		this.createEmployee = createEmployee;
	}

	@GetMapping(value = "/{job}")
	public ResponseEntity<List<Employee>> getEmployeesByJob(@PathVariable String job) {
		List<Employee> allEmployeesByJob = getEmployeesByJob.execute(job);
		return ResponseEntity.ok().body(allEmployeesByJob);
	}

	@PostMapping
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee) {
		createEmployee.execute(employee);
		return ResponseEntity.ok().build();
	}
}
