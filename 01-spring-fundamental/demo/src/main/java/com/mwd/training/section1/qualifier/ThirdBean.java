package com.mwd.training.section1.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ThirdBean {

	MyBean firstBean;
	
	MyBean secondBean;
	
	@Autowired
	MyBean myBean;
	
	@Autowired
	public ThirdBean(@Qualifier("SecondBean") MyBean secondBean) {
		
		this.secondBean=secondBean;
	}
	
	@Autowired
	@Qualifier("FirstBean")
	public void setBean(MyBean bean) {
		this.firstBean = bean;
	}
	
	public void test() {
		System.out.println("firstBean");
		this.firstBean.test();
		System.out.println("secondBean");
		this.secondBean.test();
		System.out.println("myBean");
		this.myBean.test();
		
	}
}
