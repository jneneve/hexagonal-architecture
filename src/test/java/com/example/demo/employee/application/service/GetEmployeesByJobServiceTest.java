package com.example.demo.employee.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.demo.employee.adapter.out.persistence.EmployeeRepositoryMemory;
import com.example.demo.employee.application.port.in.CreateEmployee;
import com.example.demo.employee.application.port.in.GetEmployeesByJob;
import com.example.demo.employee.application.port.out.EmployeeRepository;
import com.example.demo.employee.domain.Employee;

public class GetEmployeesByJobServiceTest {

	private final EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);

	@Test
	@DisplayName("it should get employees by job")
	public void getEmlpoyeesByJob() {
		Employee e1 = new Employee(1, "John Due", "Developer");
		Employee e2 = new Employee(1, "Mary Due", "Developer");
		EmployeeRepositoryMemory employeeRepositoryMemory = new EmployeeRepositoryMemory();
		CreateEmployee createEmployee = new CreateEmployeeService(employeeRepositoryMemory);
		GetEmployeesByJob getEmployeesByJob = new GetEmployeesByJobService(employeeRepositoryMemory);
		createEmployee.execute(e1);
		createEmployee.execute(e2);
		List<Employee> allEmployeesByJob = getEmployeesByJob.execute("Developer");
		assertThat(allEmployeesByJob.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("it should throw an exception when the job not exist")
	public void throwAnExceptionWhenTheJobNotExist() {
		List<Employee> emptyResultByJob = new ArrayList<>();
		GetEmployeesByJob getEmployeesByJob = new GetEmployeesByJobService(employeeRepository);
		given(employeeRepository.getAllByJob("anything")).willReturn(emptyResultByJob);
		assertThatThrownBy(() -> getEmployeesByJob.execute("anything")).isInstanceOf(IllegalStateException.class)
				.hasMessageContaining("Not exist employees with this job.");
	}
}
