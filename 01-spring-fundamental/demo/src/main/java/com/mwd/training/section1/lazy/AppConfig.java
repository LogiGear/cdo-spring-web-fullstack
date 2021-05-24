package com.mwd.training.section1.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


@Configuration
@ComponentScan
public class AppConfig{
	@Lazy
	@Bean(name="FirstBean")
	public FirstBean firstBean() {
		return new FirstBean();
	}

	@Bean
	public SecondBean secondBean() {
		return new SecondBean();
	}
	
	
}