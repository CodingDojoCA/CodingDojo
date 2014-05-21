package com.comarch.fizzbuzz;

import static org.junit.Assert.*;

import javax.xml.ws.ServiceMode;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FizzBuzzTest {
	
	private static final String FIZZ_BUZZ = "FizzBuzz";
	private static final String FIZZ = "Fizz";
	private static final String BUZZ = "Buzz";
	private static AlaMaKotaChecker checker;
	private static FizzBuzzConverter converter;
	
	@BeforeClass
	public static void initChecker(){
		checker = new AlaMaKotaChecker();
		converter = new FizzBuzzConverter(checker);
	}
	
	@BeforeClass
	public static void initConverter(){
		
	}

	@Test
	public void shouldCheckThreeIsFizz() throws Exception {
		assertTrue(checker.isFizz(3));
	}
	
	@Test
	public void shouldCheckFourIsNotFizz() throws Exception {
		assertFalse(checker.isFizz(4));
	}

	@Test
	public void shouldCheck15IsNotFizz() throws Exception {
		assertFalse(checker.isFizz(15));
	}

	@Test
	public void shouldCheck5IsBuzz() throws Exception {
		assertTrue(checker.isBuzz(5));
	}
	
	@Test
	public void shouldCheck15IsNotBuzz() throws Exception {
		assertFalse(checker.isBuzz(15));
	}
	
	@Test
	public void shouldCheckIs15FizzBuzz() throws Exception {
		assertTrue(checker.isFizzBuzz(15));
	}
	@Test
	public void shouldCheck14IsNotFizzBuzz() throws Exception {
		assertFalse(checker.isFizzBuzz(14));
	}
	
	@Test
	public void shouldCheck13IsNotFizzBuzz() throws Exception {
		assertFalse(checker.isFizzBuzz(13));
	}
	
	@Test
	public void hasBeenFizzWhen3Returned() throws Exception {
		FizzBuzzConverter converter = new FizzBuzzConverter(checker);
		assertEquals(FIZZ,converter.getValue(3));		
	}
	
	@Test
	public void hasBeenBuzzWhen5Returned() throws Exception {
		FizzBuzzConverter converter = new FizzBuzzConverter(checker);
		assertEquals(BUZZ, converter.getValue(5));		
	}
	
	@Test
	public void shouldConvert15ToFizzBuzz() throws Exception {
		FizzBuzzConverter converter = new FizzBuzzConverter(checker);
		assertEquals(FIZZ_BUZZ, converter.getValue(15));
	}
	@Test
	public void shouldConvert1To1() throws Exception {
		FizzBuzzConverter converter = new FizzBuzzConverter(checker);
		assertEquals("1", converter.getValue(1));
	}
	
	@Test
	public void convertsRangeFrom4To10() throws Exception {
		assertArrayEquals(new String[]{"4", BUZZ, FIZZ, "7", "8", FIZZ, BUZZ}, converter.convertRange(4, 10).toArray());
	}
	
	@Test
	public void convertsRangeFrom15To16() throws Exception {
		assertArrayEquals(new String[]{FIZZ_BUZZ, "16"}, converter.convertRange(15, 16).toArray());
	}
	
}
