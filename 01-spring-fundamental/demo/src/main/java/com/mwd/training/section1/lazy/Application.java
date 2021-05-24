package com.mwd.training.section1.lazy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
	
	public static void main(String[] args) {
		System.out.println("Start main");
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("After contructor ApplicationContext");
		FirstBean firstBean = context.getBean(FirstBean.class);
		firstBean.test();
		
		
		context.close();
		System.out.println("End main");
	}

}
