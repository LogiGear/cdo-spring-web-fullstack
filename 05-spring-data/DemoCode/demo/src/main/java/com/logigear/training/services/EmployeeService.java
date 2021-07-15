package com.logigear.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logigear.training.entities.Employee;
import com.logigear.training.exception.EmployeeAlreadyExistsException;
import com.logigear.training.exception.EmployeeNotFoundException;
import com.logigear.training.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository repository;
	@Autowired
	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public List<Employee> getAll() {
		return this.repository.findAll();
	}
	
	public List<Employee> getByLikeFullname(String fullname) {
		return this.repository.findEmployeeByLikeFullName(fullname)
                .orElseThrow(EmployeeNotFoundException::new);
	}
	
	public Employee getById(String username) {
		return this.repository.findById(username).orElseThrow(EmployeeNotFoundException::new);
	}
	
	public Employee update(Employee requestedEmp, String username) {
		Optional<Employee> foundedEmployee = this.repository.findById(username);
		if (foundedEmployee.isEmpty())
			throw new EmployeeNotFoundException();
		return this.repository.save(requestedEmp);
	}
	
	public Employee add(Employee emp) {	
		Optional<Employee> foundedEmployee = this.repository.findById(emp.getUsername());
		if (foundedEmployee.isPresent())
			throw new EmployeeAlreadyExistsException();
		else
			return this.repository.saveAndFlush(emp);
	}
	
	public void delete(String username) {
		this.repository.deleteById(username);
	}
	
}
