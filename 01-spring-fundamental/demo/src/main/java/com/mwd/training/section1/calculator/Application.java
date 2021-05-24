package com.mwd.training.section1.calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Expressions exp = context.getBean(Expressions.class);
		System.out.println("[Add] Result: " + exp.add(100, 200));
		System.out.println("[Subtract] Result: " + exp.subtract(501, 200));
		context.close();
		
	}

}
