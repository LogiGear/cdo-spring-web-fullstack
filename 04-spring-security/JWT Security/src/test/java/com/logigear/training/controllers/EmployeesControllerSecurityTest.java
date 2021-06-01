package com.logigear.training.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.training.entities.Employee;
import com.logigear.training.jwt.JwtRequest;
import com.logigear.training.services.EmployeeService;
import com.logigear.training.utils.TestUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest()
public class EmployeesControllerSecurityTest {

    private static final String API_URL = "/api/v1/employees";

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

    @MockBean
    private EmployeeService service;

	@Test
	@WithMockUser(username = "admin", authorities = { "ADMIN" })
	public void givenCorrectCredential_shouldSucceedWith200() throws Exception {
		mvc.perform(post("/api/v1/employees").contentType(MediaType.APPLICATION_JSON)
				
				.characterEncoding("utf-8")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
    /*@Test
    public void insertAnExistedEmployeeTest() throws Exception {
        //given
        Employee employee = new Employee();
        employee.setUsername("admin");
        employee.setPassword("admin");
        employee.setFullname("Administrator");
        employee.setRole("Admin");

        //when
        Employee retEmployee = new Employee();
        when(service.add(employee)).thenReturn(retEmployee);

        mvc.perform(post(API_URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(employee)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        .andExpect(content().string(Boolean.toString(false)));
    }

    @Test
    public void deleteAnExistedEmployee() throws Exception {
        String username = "admin";
        service.delete(username);
        mvc.perform(delete(API_URL+"/"+username))
                .andExpect(status().isOk());

    }

    @Test
    public void updateExistedEmployeeAdmin() throws Exception {
        //given
        Employee employee = new Employee();
        employee.setUsername("admin");
        employee.setPassword("xinchao");
        employee.setFullname("Administratorstrator");
        employee.setRole("User");

        //when
        Employee retEmployee = new Employee();
        when(service.update(employee, employee.getUsername())).thenReturn(retEmployee);

        mvc.perform(patch(API_URL+"/"+employee.getUsername())
        .contentType(MediaType.APPLICATION_JSON)
        .content(TestUtil.convertObjectToJsonBytes(employee)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(Boolean.toString(true)));
    }

    @Test
    public void insertANonExistedEmployeeTest() throws Exception {
        //given
        Employee employee = new Employee();
        employee.setUsername("admin2");
        employee.setPassword("admin");
        employee.setFullname("Administrator");
        employee.setRole("Admin");

        //when
        Employee retEmployee = new Employee();
        when(service.add(employee)).thenReturn(retEmployee);

        mvc.perform(post(API_URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(employee)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Boolean.toString(true)));
    }*/

}
