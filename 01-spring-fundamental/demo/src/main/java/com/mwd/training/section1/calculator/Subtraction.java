package com.mwd.training.section1.calculator;

public class Subtraction  {
	public long apply(long a, long b) {
		return a - b;
	}

	public boolean valid(char operator) {
		return '-' == operator;
	}
}
