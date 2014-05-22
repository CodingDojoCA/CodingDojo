package com.comarch.tdd;

import com.comarch.tdd.exceptions.NegativeNumberException;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@Before
	public void init() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void returns0onEmptyString() throws Exception {
		assertEquals(0, stringCalculator.add(""));
	}

	@Test
	public void returns1OnStringWithOnly1() throws Exception {
		assertEquals(1, stringCalculator.add("1"));
	}

	@Test
	public void returns3OnStringWith1_2() throws Exception {
		assertEquals(3, stringCalculator.add("1,2"));
	}

	@Test
	public void returns100forSum10_50_10_30() throws Exception {
		assertEquals(100, stringCalculator.add("10,50,10,30"));
	}

	@Test
	public void returnsSumForRandomNumbers() throws Exception {
		Random randomGenerator = new Random();
		int count = randomGenerator.nextInt(1000);
		int sum = 0;
		int number;
		String testEntry = "";
		for (int i = 0; i < count; i++) {
			number = randomGenerator.nextInt(1000);
			sum += number;
			testEntry += "," + number;
		}
		testEntry = testEntry.substring(1, testEntry.length());
		assertEquals(sum, stringCalculator.add(testEntry));
	}

	@Test
	public void returns15For3And4and3And5() throws Exception {
		assertEquals(15, stringCalculator.add("3,4\n3,5"));
	}

	@Test
	public void returns3forChangeDelimiterSyntax() throws Exception {
		assertEquals(3, stringCalculator.add("//[\\n]\n1\n2"));
	}

	@Test(expected = NegativeNumberException.class)
	public void throwsNegativeNumberException() throws Exception {
		stringCalculator.add("2,-10,2");
	}

	@Test
	public void exceptionContainsMessageWithAllNegativeNumbers() throws Exception {
		try {
			stringCalculator.add("2,-10,2,-1,5,-8");
			fail();
		} catch (NegativeNumberException ex) {
			assertTrue(ex.getMessage().startsWith("negatives not allowed"));
			assertTrue(ex.getMessage().contains("-10"));
			assertTrue(ex.getMessage().contains("-1"));
			assertTrue(ex.getMessage().contains("-8"));
		}
	}

	@Test
	 public void ingoresNumbersBiggerThan1000() throws Exception {
		assertEquals(40, stringCalculator.add("18,2000,1001,2,20"));
	}

	@Test
	public void checkChustomDelimiter() throws Exception {
		assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
	}
}
