package com.comarch.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClass {
	Checker checker = new Checker();
	Calculator calculator = new Calculator();

	@Test
	public void isEmpty() throws Exception {
		assertTrue(checker.isEmpty(""));
	}

	@Test
	public void isOne() throws Exception {
		assertEquals("1", checker.getValue("1"));
	}

	@Test
	public void isTwo() throws Exception {
		assertEquals("2", checker.getValue("2"));
	}

	@Test
	public void isZero() throws Exception {
		assertEquals("", checker.getValue("0"));
	}

	@Test
	public void getEmptyStringFromMethod() throws Exception {
		assertArrayEquals(new String[] { "" }, calculator.getParams(""));
	}

	@Test
	public void getNumbersFromMethod() throws Exception {
		assertArrayEquals(new String[] { "1", "2" },
				calculator.getParams("1,2"));
	}

	@Test
	public void shouldBeZero() throws Exception {
		assertEquals(0, calculator.add(""));
	}

	@Test
	public void shouldAddManyNumbers() throws Exception {
		assertEquals(8, calculator.add("1,2,3,2"));
	}

	@Test
	public void shouldAddNumbersWithNewLine() throws Exception {
		assertEquals(8, calculator.add("1,2\n3,2"));
	}

	@Test
	public void shouldAddNumbersWithSeparator() throws Exception {
		assertEquals(3, calculator.add("//[;]\n1;2"));
	}
	
	@Test
	public void shouldReturnNegativeValueException() throws Exception {
		try{
			calculator.add("-1,2");
			fail();
		}catch(NegativeValueException ex){
			assertArrayEquals(new String[]{"-1"},ex.valueList.toArray());
		}
	}
	
	@Test
	public void shouldReturnNegativeMultiValueException() throws Exception {
		try{
			calculator.add("-1,2,3,-2,13,-2");
			fail();
		}catch(NegativeValueException ex){
			System.out.println(ex.getMessage());
			assertArrayEquals(new String[]{"-1","-2","-2"},ex.valueList.toArray());
		}
	}
	
	@Test
	public void shouldIgnoredMoreThen1000() throws Exception {
		assertEquals(1010, calculator.add("1,2,3,2,1001,1002,2,1000"));
	}
	
	@Test
	public void shouldBe1000() throws Exception {
		assertEquals(1000, calculator.add("1000"));
	}
	
	@Test
	public void shouldBe6() throws Exception {
		assertEquals(6, calculator.add("//[***]\n1***2***3"));
	}

}
