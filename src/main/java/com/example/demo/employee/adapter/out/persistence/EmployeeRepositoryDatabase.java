package com.example.demo.employee.adapter.out.persistence;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.employee.application.port.out.EmployeeRepository;
import com.example.demo.employee.domain.Employee;

@Repository
public class EmployeeRepositoryDatabase implements EmployeeRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeRepositoryDatabase(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(Employee employee) {
		String sql = "INSERT INTO employee (name, job) VALUES (?, ?)";
		this.jdbcTemplate.update(sql, new Object[] { employee.getName(), employee.getJob() },
				new int[] { Types.VARCHAR, Types.VARCHAR });
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllByJob(String job) {
		String sql = "SELECT * FROM employee e WHERE e.job = ?";
		return this.jdbcTemplate.query(sql, new Object[] { job }, new int[] { Types.VARCHAR },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}
}
