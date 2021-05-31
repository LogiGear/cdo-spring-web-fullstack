package com.logigear.training.controllers;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.logigear.training.models.AuthenticateRequestDTO;
import com.logigear.training.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@GetMapping("login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "Login", method = RequestMethod.POST)
	public String authenticate(@RequestParam(name = "txtUsername")String username,
	@RequestParam(name = "txtPassword") String password) {
		AuthenticateRequestDTO authenticateRequestDTO = 
				new AuthenticateRequestDTO(username, password);
		System.out.println(authenticateRequestDTO.getUsername());
		System.out.println(service.authenticate(authenticateRequestDTO));
		return "error";
	}
	
	
}
