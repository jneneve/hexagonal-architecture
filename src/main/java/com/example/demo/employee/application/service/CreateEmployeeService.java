package com.example.demo.employee.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.application.port.in.CreateEmployee;
import com.example.demo.employee.application.port.out.EmployeeRepository;
import com.example.demo.employee.domain.Employee;

@Service
public class CreateEmployeeService implements CreateEmployee {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public CreateEmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void execute(Employee employee) {
		this.employeeRepository.save(employee);
	}
}
