package com.logigear.training.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.logigear.training.entities.Employee;
import com.logigear.training.jwt.JwtAuthenticationEntryPoint;
import com.logigear.training.jwt.JwtRequestFilter;
import com.logigear.training.services.EmployeeService;
import com.logigear.training.services.JwtUserDetailsService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeesControllerFunctionalTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@MockBean
	JwtUserDetailsService jwtUserDetailsService;
	
	@MockBean
	JwtRequestFilter jwtRequestFilter;
	
	@MockBean
	EmployeeService employeeService;
	
    @Test
    public void givenAuthRequestOnPublicService_shouldSucceedWith200() throws Exception {
    	
    	employeeService.add(new Employee("a", "a", "a a", "ADMIN"));
        ResultActions ret = mvc.perform(get("/api/v1/employees").contentType(MediaType.APPLICATION_JSON));
        int a =0;  
    }
}
