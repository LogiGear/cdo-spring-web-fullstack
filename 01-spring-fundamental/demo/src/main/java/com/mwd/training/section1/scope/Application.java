package com.mwd.training.section1.scope;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
		if( context.getBean(MessageServiceSingleton.class) == 
				context.getBean(MessageServiceSingleton.class)) {
			System.out.println("messageService1 and messageService2 are the same" );
		}
		else {
			System.out.println("messageService1 and messageService2 are not the same" );
		}
		
		
		context.close();
	}

}
