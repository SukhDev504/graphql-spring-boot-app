package com.cybage.springgraphql.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.cybage.springgraphql.model.Employee;
import com.cybage.springgraphql.repository.EmployeeRepository;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeMutation implements GraphQLMutationResolver {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee createEmployee(String name, String gender, String emailID, String mobileNo, String dob, String role,
			String booldGroup, int salary) {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmailID(emailID);
		emp.setMobileNo(mobileNo);
		emp.setDob(dob);
		emp.setRole(role);
		emp.setGender(gender);
		emp.setBloodGroup(booldGroup);
		emp.setSalary(salary);
		log.info("Employee :=>" + emp.toString());
		return employeeRepository.save(emp);
	}

	public Employee updateEmployee(int id, String name, String gender, String emailID, String mobileNo, String dob,
			String role, String booldGroup, int salary) throws NotFoundException {

		Optional<Employee> optEmployee = employeeRepository.findById(id);

		if (optEmployee.isPresent()) {
			Employee emp = optEmployee.get();

			if (name != null)
				emp.setName(name);
			if (emailID != null)
				emp.setEmailID(emailID);
			if (mobileNo != null)
				emp.setMobileNo(mobileNo);
			if (dob != null)
				emp.setDob(dob);
			if (role != null)
				emp.setRole(role);
			if (gender != null)
				emp.setGender(gender);
			if (booldGroup != null)
				emp.setBloodGroup(booldGroup);
			if (salary != 0)
				emp.setSalary(salary);

			employeeRepository.save(emp);
			return emp;
		}

		throw new NotFoundException("Not found Employee to update!");

	}

	public boolean deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return true;
	}

}
