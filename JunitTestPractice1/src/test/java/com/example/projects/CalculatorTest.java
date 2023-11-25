package com.example.projects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	Calculator calc;
	@Test
	public void mul() {
		calc=new Calculator();
		assertEquals(10, calc.mul(2, 5));
	}
	
	@Test
	public void div() {
		calc=new Calculator();
		assertEquals(2, calc.div(10, 5));
	}
}
