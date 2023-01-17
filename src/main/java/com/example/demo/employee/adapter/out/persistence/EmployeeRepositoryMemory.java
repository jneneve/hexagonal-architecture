package com.example.demo.employee.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.employee.application.port.out.EmployeeRepository;
import com.example.demo.employee.domain.Employee;

public class EmployeeRepositoryMemory implements EmployeeRepository {

	private List<Employee> employees = new ArrayList<>();

	@Override
	public void save(Employee employee) {
		employees.add(employee);
	}

	@Override
	public int count() {
		return employees.size();
	}

	@Override
	public Employee getEmployee(Integer id) {
		for (Employee employee : employees) {
			if (employee.getId() == id)
				return employee;
		}
		return null;
	}

	@Override
	public List<Employee> getAllByJob(String job) {
		List<Employee> employeesByJob = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getJob() == job) {
				employeesByJob.add(employee);
			}
		}
		return employeesByJob;
	}
}
