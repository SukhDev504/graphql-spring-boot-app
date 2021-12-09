package com.cybage.springgraphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.springgraphql.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByRole(String role);

	public List<Employee> findByBloodGroup(String bloodGroup);

	public List<Employee> findByName(String name);

	public List<Employee> findBySalary(int salary);

	public List<Employee> findBySalaryLessThan(int salary);

	public List<Employee> findBySalaryLessThanEqual(int salary);

	public List<Employee> findBySalaryGreaterThan(int salary);

}
