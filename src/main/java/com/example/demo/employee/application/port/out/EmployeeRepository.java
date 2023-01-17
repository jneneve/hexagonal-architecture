package com.example.demo.employee.application.port.out;

import java.util.List;

import com.example.demo.employee.domain.Employee;

public interface EmployeeRepository {

	public void save(Employee employee);

	public int count();

	public Employee getEmployee(Integer id);
	
	public List<Employee> getAllByJob(String job);
}
