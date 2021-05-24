package com.mwd.training.section1.calculator;

import org.springframework.stereotype.Component;

@Component
public class Addition implements Operation {
	@Override
	public long apply(long a, long b) {
		return a + b;
	}

	@Override
	public boolean valid(char operator) {
		return '+' == operator;
	}
}
