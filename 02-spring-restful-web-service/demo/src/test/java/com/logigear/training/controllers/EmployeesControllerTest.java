package com.logigear.training.controllers;

import com.logigear.training.entities.Employee;
import com.logigear.training.repositories.EmployeeRepository;
import com.logigear.training.services.EmployeeService;
import com.logigear.training.utils.TestUtil;
import org.apiguardian.api.API;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeesControllerTest {

    private static final String API_URL = "/api/v1/employees";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService service;


    @Test
    public void insertAnExistedEmployeeTest() throws Exception {
        //given
        Employee employee = new Employee();
        employee.setUsername("admin");
        employee.setPassword("admin");
        employee.setFullname("Administrator");
        employee.setRole("Admin");

        //when
        when(service.add(employee)).thenReturn(false);

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
        when(service.update(employee, employee.getUsername())).thenReturn(true);

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
        when(service.add(employee)).thenReturn(true);

        mvc.perform(post(API_URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(employee)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Boolean.toString(true)));
    }

}
