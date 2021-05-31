package com.logigear.training.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("USER")
public class HelloController {
	
	@GetMapping("/")
	public String hello(Map<String, Object> model) {
		model.put("company", "LogiGear");
		return "hello";
	}

}
