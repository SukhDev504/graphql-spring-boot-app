package com.cybage.springgraphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.cybage.springgraphql.model.Employee;
import com.cybage.springgraphql.repository.EmployeeRepository;

@Component
public class EmployeeQuery implements GraphQLQueryResolver {

	@Autowired
	EmployeeRepository empoyeeRepository;

	public List<Employee> getEmployees() {
		return empoyeeRepository.findAll();

	}

	public Employee getEmployee(int id) {
		return empoyeeRepository.findById(id).orElseThrow(null);

	}

	public long countEmployee() {
		return empoyeeRepository.count();
	}

	public List<Employee> getEmployeesByRole(String role) {
		return empoyeeRepository.findByRole(role);
	}

	public List<Employee> getEmployeesByBloodGroup(String bloodGroup) {
		return empoyeeRepository.findByBloodGroup(bloodGroup);

	}

	public List<Employee> getEmployeesByName(String name) {
		return empoyeeRepository.findByName(name);

	}

	public List<Employee> getEmployeesBySalary(int salary) {
		return empoyeeRepository.findBySalary(salary);

	}

	public List<Employee> getEmployeesBySalaryLessThan(int salary) {
		return empoyeeRepository.findBySalaryLessThan(salary);

	}

	public List<Employee> getEmployeesBySalaryLessThanEqual(int salary) {
		return empoyeeRepository.findBySalaryLessThanEqual(salary);

	}

	public List<Employee> getEmployeesBySalaryGreaterThan(int salary) {
		return empoyeeRepository.findBySalaryGreaterThan(salary);

	}

}
