package com.mwd.training.section1.qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// test Qualifier
		ThirdBean thirdBean = context.getBean(ThirdBean.class);
		thirdBean.test();
		context.close();
	}

}
