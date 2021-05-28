package com.example.demo.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerRestTemplateIntegrationTest {

    @Autowired
    private TestRestTemplate template;
    
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        ResponseEntity<String> result = template.withBasicAuth("user", "pass")
          .getForEntity("/data", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
    
    @Test
    public void givenAuthRequestOnPrivateService_shouldFailWith201() throws Exception {
        ResponseEntity<String> result = template.withBasicAuth("user", "wrongpass")
          .getForEntity("/data", String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }
}
