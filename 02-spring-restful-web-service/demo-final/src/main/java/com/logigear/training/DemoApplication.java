package com.logigear.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Swagger UI Documentation URL: http://localhost:8080/swagger-ui/");
		SpringApplication.run(DemoApplication.class, args);
	}

}
