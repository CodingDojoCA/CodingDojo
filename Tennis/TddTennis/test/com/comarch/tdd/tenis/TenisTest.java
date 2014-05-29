package com.comarch.tdd.tenis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kleko on 2014-05-23.
 */
public class TenisTest {

	private TenisBoard tenisBoard;

	@Before
	public void init() {
		this.tenisBoard = new TenisBoard();
	}

	@Test
	public void testZeroZeroOnInit() throws Exception {
		assertEquals("love : love", tenisBoard.getResult());
	}

	@Test
	public void testAddScoreToPlayers() throws Exception {
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(2);
		assertEquals("fifteen : fifteen", tenisBoard.getResult());
	}

	@Test
	public void testAdd2PointToFirstPlayer() throws Exception {
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		assertEquals("thirty : love", tenisBoard.getResult());
	}

	@Test
	public void testAdd3PointToFirstPlayer() throws Exception {
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		assertEquals("fourty : love", tenisBoard.getResult());
	}

	@Test(expected = InvalidPlayerNumberException.class)
	public void testFailForThirdPlayer() throws Exception {
		tenisBoard.addPoint(3);
	}

	@Test
	public void testDeuce() throws Exception {
		for (int i = 1; i < 6; i++) {
			tenisBoard.addPoint(1);
			tenisBoard.addPoint(2);
		}
		assertEquals("deuce", tenisBoard.getResult());
	}

	@Test
	public void testAdventageForSecondPlayer() throws Exception {
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(2);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(2);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(2);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(2);
		tenisBoard.addPoint(2);
		assertEquals("advantage P2", tenisBoard.getResult());
	}

	@Test
	public void testAdventageForFirstPlayer() throws Exception {
		tenisBoard.addPoint(2);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(2);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(2);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(2);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		assertEquals("advantage P1", tenisBoard.getResult());
	}

	@Test
	public void plyaerOneWinAfter4Points() throws Exception {
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		assertEquals("P1 wins games", tenisBoard.getResult());
	}

	@Test(expected = CannotAddPointException.class)
	public void testFailAddPointIfPlayerWon() throws Exception {
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
	}

	@Test(expected = CannotAddPointException.class)
	public void testFailAddPointIfPlayerWon6to2() throws Exception {
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(2);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(2);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
		tenisBoard.addPoint(1);
	}
}
