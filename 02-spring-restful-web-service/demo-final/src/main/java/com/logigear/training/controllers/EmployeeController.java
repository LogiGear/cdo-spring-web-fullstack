package com.logigear.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.logigear.training.entities.Employee;
import com.logigear.training.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	private final EmployeeService service;
	
	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}


	@GetMapping("{username}")
	public ResponseEntity<Employee> getEmployeeByUsername(@PathVariable("username") String username) {
		return ResponseEntity.ok(this.service.getById(username));
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/search/{search}")
	public ResponseEntity<List<Employee>> getEmployeesByLikeName(@PathVariable("search") String search) {
		return ResponseEntity.ok(service.getByLikeFullname(search));
	}
	
	@PostMapping
	public ResponseEntity<Boolean> addEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(service.add(employee));
	}
	
	@PatchMapping("{username}")
	public ResponseEntity<Boolean> updateEmployeeByUsername(@PathVariable("username") String username,
			@RequestBody Employee employee) {
		return ResponseEntity.ok(service.update(employee,username));
	}
	
	@DeleteMapping("{username}")
	public ResponseEntity<HttpStatus> deleteEmployeeByUsername(@PathVariable("username") String username) {
		service.delete(username);
		return ResponseEntity.ok().build();
	}
	

}
