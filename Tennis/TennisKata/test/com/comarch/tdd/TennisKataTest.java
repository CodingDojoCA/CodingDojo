package com.comarch.tdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.comarch.exception.GemFinishedException;

public class TennisKataTest {
	ResultHandler resultHandler;

	@Before
	public void setUp() throws Exception {
		resultHandler = new ResultHandler();

	}

	@Test
	public void loveLoveAtBegiinging() {
		assertEquals("0-0", resultHandler.getActual());
	}

	@Test
	public void fifteenLove() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		assertEquals("15-0", resultHandler.getActual());
		
	}
	
	@Test
	public void fifteenFifteen() throws GemFinishedException{
		resultHandler.addSecondPlayerPoint();
		assertEquals("0-15", resultHandler.getActual());
	}
	@Test
	public void fourtyLove() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		assertEquals("40-0", resultHandler.getActual());
	}
	@Test
	public void thirtyFourty() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		assertEquals("30-40", resultHandler.getActual());
	}
	
	@Test
	public void deuceTest() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		assertEquals("deuce", resultHandler.getActual());
	}
	
	@Test
	public void p1WinsTest() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		assertEquals("P1 wins the game:)", resultHandler.getActual());
	}
	
	@Test
	public void p2WinsTest() throws GemFinishedException{
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		assertEquals("P2 wins the game:)", resultHandler.getActual());
	}

	@Test
	public void advantageP2Test() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		assertEquals("advantage P2", resultHandler.getActual());
	}
	@Test
	public void advantageP1Test() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		assertEquals("advantage P1", resultHandler.getActual());
	}
	
	@Test(expected = GemFinishedException.class)
	public void p1WinsTestWithMoreGems() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
	}
	@Test(expected = GemFinishedException.class)
	public void p2WinsTestWithMoreGems() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
	}
	
	@Test
	public void longDeuce() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		assertEquals("deuce", resultHandler.getActual());
	}
	
	@Test
	public void p2winWith2advantage() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		assertEquals("P2 wins the game:)", resultHandler.getActual());
	}
}
