/*package com.comarch.tdd;

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
	public void loveFifteen() throws GemFinishedException{
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
		assertEquals(ResultHandler.DEUCE, resultHandler.getActual());
	}
	
	@Test
	public void p1WinsTest() throws GemFinishedException{
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		resultHandler.addFirstPlayerPoint();
		assertEquals(ResultHandler.P1WINS, resultHandler.getActual());
	}
	
	@Test
	public void p2WinsTest() throws GemFinishedException{
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		resultHandler.addSecondPlayerPoint();
		assertEquals(ResultHandler.P2WINS, resultHandler.getActual());
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
		assertEquals(ResultHandler.P2ADV, resultHandler.getActual());
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
		assertEquals(ResultHandler.P1ADV, resultHandler.getActual());
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
		assertEquals(ResultHandler.DEUCE, resultHandler.getActual());
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
		assertEquals(ResultHandler.P2WINS, resultHandler.getActual());
	}
}
*/