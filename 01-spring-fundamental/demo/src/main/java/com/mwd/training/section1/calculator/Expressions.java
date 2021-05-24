package com.mwd.training.section1.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Expressions {
	@Autowired
	Addition addition;
	
	@Autowired
	Subtraction subtraction;
	
	public long add ( long arg1, long arg2) {
		return addition.apply(arg1, arg2);
	}
	public long subtract ( long arg1, long arg2) {
		return subtraction.apply(arg1, arg2);
	}
	
	
}
