package com.logigear.training;

import com.logigear.training.entities.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetAllEmployeesWhenTheEmployeeListIsEmpty() throws Exception {
		List<Employee> list = Collections.emptyList();
		ResponseEntity<List> response =  restTemplate.getForEntity(
				new URL("http://localhost:"+port + "/api/v1/employees").toString(), List.class);
			assertEquals(list, response.getBody());

	}

}
