package com.mwd.training.section1.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class OperationConfig {
	@Bean
	Subtraction getSubtraction() {
		return new Subtraction();
	}
}