package com.mwd.training.section1.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;


@Configuration
@ComponentScan
public class AppConfig{
	@Bean(name="FirstBean")
	public FirstBean firstBean() {
		return new FirstBean();
	}

	@Primary
	@Bean(name="SecondBean")
	public SecondBean secondBean() {
		return new SecondBean();
	}
	
}