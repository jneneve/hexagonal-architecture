package com.example.demo.employee.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.employee.adapter.out.persistence.EmployeeRepositoryMemory;
import com.example.demo.employee.application.port.in.CreateEmployee;
import com.example.demo.employee.application.port.out.EmployeeRepository;
import com.example.demo.employee.domain.Employee;

public class CreateEmployeeServiceTest {

	@Test
	@DisplayName("it should create an employee")
	public void createAnEmployee() {
		Employee employee = new Employee(1, "John Due", "Developer");
		EmployeeRepository employeeRepository = new EmployeeRepositoryMemory();
		CreateEmployee createEmployee = new CreateEmployeeService(employeeRepository);
		createEmployee.execute(employee);
		Employee objectSave = employeeRepository.getEmployee(employee.getId());
		assertThat(objectSave.getName()).isEqualTo(employee.getName());
	}
}
