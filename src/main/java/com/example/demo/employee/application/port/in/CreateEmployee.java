package com.example.demo.employee.application.port.in;

import com.example.demo.employee.domain.Employee;

public interface CreateEmployee {

	public void execute(Employee employee);
}
