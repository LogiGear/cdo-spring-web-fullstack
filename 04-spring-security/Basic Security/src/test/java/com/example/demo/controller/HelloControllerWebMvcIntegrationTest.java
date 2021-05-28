package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerWebMvcIntegrationTest {

    @Autowired
    private MockMvc mvc;
    
    @WithMockUser(value = "spring")
    @Test
    public void givenAuthRequestOnPublicService_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/hello").contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());
    }
    
    @WithMockUser(value = "spring")
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/data").contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());
    }
}
