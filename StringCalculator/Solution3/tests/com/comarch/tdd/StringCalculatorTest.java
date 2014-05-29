package com.comarch.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@Before
	public void init() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void returns0onEmptyString() {
		assertEquals(0, stringCalculator.add(""));
	}

	@Test
	public void returns1OnStringWithOnly1() {
		assertEquals(1, stringCalculator.add("1"));
	}

	@Test
	public void returns3OnStringWith1_2() {
		assertEquals(3, stringCalculator.add("1,2"));
	}

	@Test
	public void returnsSumOf3Numbers() {
		assertEquals(6, stringCalculator.add("1,2,3"));
	}
	
	@Test
	public void returns6WithCommaAndNewLineAsSeparators() {
		assertEquals(6, stringCalculator.add("1\n2,3"));
	}
	
	
	@Test
	public void returns3ForNumbers1_2WithDeclaredDelimiter() {
		assertEquals(3, stringCalculator.add("//[;]\n1;2"));
	}
	
	@Test
	public void returns3ForNumbers1_2_3WithDeclaredDelimiters() {
		assertEquals(6, stringCalculator.add("//[\\n|,]\n1\n2,3"));
	}
	
	@Test
	public void throwsExceptionWhenNegativeNumber() {
		try {
			stringCalculator.add("-1,9,-3");
			
			fail();
		} catch (NegativeNumberPassed ex) {
			assertEquals("Negatives not allowed, but found: -1, -3", ex.getMessage());
		}
	}
	
	@Test
	public void sumMethodIgnoresNumber1000() {
		assertEquals(2,stringCalculator.add("//[+]\n2+1023"));
	}
	
	@Test
	public void sumMethodWithBracketedDelimeter() {
		assertEquals(6,stringCalculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void shouldReplace() {
		assertEquals("\\*\\*\\*", "***".replace("*", "\\*"));
	}
	
	@Test
	public void shouldReplace2() {
		assertEquals("222", "111".replaceAll("1", "\\2"));
	}

}
