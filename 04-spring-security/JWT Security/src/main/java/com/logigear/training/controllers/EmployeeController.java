package com.logigear.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.logigear.training.entities.Employee;
import com.logigear.training.services.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	private final EmployeeService service;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@Operation(summary = "Read an employee's information. 'ADMIN' can read all emplyee's information, 'USER' can only read his informtion")
	@PreAuthorize("(hasRole('USER') and #username == authentication.principal.username) or hasRole('ADMIN')")
	@GetMapping("{username}")
	public ResponseEntity<Employee> getEmployeeByUsername(@PathVariable("username") String username) {
		return ResponseEntity.ok(this.service.getById(username));
	}

	@Operation(summary = "Get all employee's information. Only 'ADMIN' can get this information")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(service.getAll());
	}

	@Operation(summary = "Search an employee's accounts by fullname. Only 'ADMIN' can search this information")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/search/{search}")
	public ResponseEntity<List<Employee>> getEmployeesByLikeName(@PathVariable("search") String search) {
		return ResponseEntity.ok(service.getByLikeFullname(search));
	}

	@Operation(summary = "Add an employee's account. Only 'ADMIN' can add employee's account")
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		employee.setPassword(bcryptEncoder.encode(employee.getPassword()));
		return ResponseEntity.ok(service.add(employee));
	}

	@Operation(summary = "Update an employee's information. 'ADMIN' can update all emplyee's information, 'USER' can only update his informtion")
	@PreAuthorize("(hasRole('USER') and #username == authentication.principal.username) or hasRole('ADMIN')")
	@PatchMapping("{username}")
	public ResponseEntity<Employee> updateEmployeeByUsername(@PathVariable("username") String username,
			@RequestBody Employee employee) {
		return ResponseEntity.ok(service.update(employee, username));
	}

	@Operation(summary = "Delete an employee's account. 'ADMIN' can delete all emplyee's account, 'USER' can only delete his account")
	@PreAuthorize("(hasRole('USER') and #username == authentication.principal.username) or hasRole('ADMIN')")
	@DeleteMapping("{username}")
	public ResponseEntity<HttpStatus> deleteEmployeeByUsername(@PathVariable("username") String username) {
		service.delete(username);
		return ResponseEntity.ok().build();
	}

}
