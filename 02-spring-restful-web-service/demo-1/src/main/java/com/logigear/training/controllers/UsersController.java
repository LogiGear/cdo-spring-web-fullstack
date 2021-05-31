package com.logigear.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logigear.training.models.UsersDTO;
import com.logigear.training.services.LoginService;

@RestController
@RequestMapping("/api/v1/users") //REST naming convention
public class UsersController {
	
	//@RestController = @Controller + @ResponseBody
	
	@Autowired
	private LoginService service;
	
	@GetMapping
	public ResponseEntity<List<UsersDTO>> getAll() {
		return ResponseEntity.ok(service.findAll());
		//Status: 200
		//Body: JSON Users
	}
	
	@GetMapping("{username}")
	public ResponseEntity<UsersDTO> getByUsername(@PathVariable("username") String username) {
		return ResponseEntity.ok(service.findById(username));
		//Status: 200
		//Body: JSON User
	}
	
	@PostMapping
	public ResponseEntity<UsersDTO> addUser(@RequestBody UsersDTO user) {
		//POST -> 201 (Created)
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.addNewUser(user));
	}
	
	//http://localhost:8080/api/v1/users/admin
	@DeleteMapping("{username}")
	public ResponseEntity<UsersDTO> removeUser(@PathVariable("username")
	String username) {
		service.removeAUser(username);
		return ResponseEntity.ok().build();
	}
	
	

}
