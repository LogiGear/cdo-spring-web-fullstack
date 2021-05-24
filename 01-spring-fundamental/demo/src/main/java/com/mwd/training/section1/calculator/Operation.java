package com.mwd.training.section1.calculator;

public interface Operation {
	long apply(long a, long b);
	boolean valid(char operator);
}
