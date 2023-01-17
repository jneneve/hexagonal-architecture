package com.example.demo.employee.application.port.in;

import java.util.List;

import com.example.demo.employee.domain.Employee;

public interface GetEmployeesByJob {

	public List<Employee> execute(String job);
}
