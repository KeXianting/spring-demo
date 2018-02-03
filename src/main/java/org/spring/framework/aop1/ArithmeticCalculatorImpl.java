package org.spring.framework.aop1;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {


	public int add(int i, int j) {
		int result = i + j;
		return result;
	}


	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}


	public int mul(int i, int j) {
		int result = i * j;
		return result;
	}


	public int div(int i, int j) {
		int result = i / j;
		return result;
	}

}
