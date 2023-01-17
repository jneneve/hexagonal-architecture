package com.example.demo.employee.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.application.port.in.GetEmployeesByJob;
import com.example.demo.employee.application.port.out.EmployeeRepository;
import com.example.demo.employee.domain.Employee;

@Service
public class GetEmployeesByJobService implements GetEmployeesByJob {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public GetEmployeesByJobService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> execute(String job) {
		List<Employee> allEmployeesByJob = this.employeeRepository.getAllByJob(job);
		if (allEmployeesByJob.isEmpty()) {
			throw new IllegalStateException("Not exist employees with this job.");
		}
		return allEmployeesByJob;
	}
}
