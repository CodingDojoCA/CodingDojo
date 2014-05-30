package com.comarch.tennis;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClass {
	ScoringBoard board = new ScoringBoard(0,0);

	@Test
	public void isLoveLove() throws Exception {
		assertEquals("love-love", board.getResult(0, 0));
	}

	@Test
	public void isLoveFifteen() throws Exception {
		assertEquals("love-fifteen", board.getResult(0, 1));
	}

	@Test
	public void isFifteenFifteen() throws Exception {
		assertEquals("fifteen-fifteen", board.getResult(1, 1));
	}

	@Test
	public void is15_30() throws Exception {
		assertEquals("fifteen-thirty", board.getResult(1, 2));
	}

	@Test
	public void isP1Adventage() throws Exception {
		assertEquals("adventage P1", board.getResult(4, 3));
	}

	@Test
	public void isP1Win() throws Exception {
		assertEquals("P1 wins game", board.getResult(5, 3));
	}

	@Test
	public void isP2Win() throws Exception {
		assertEquals("P2 wins game", board.getResult(1, 4));
	}

	@Test
	public void isP2Win4To2() throws Exception {
		assertEquals("P2 wins game", board.getResult(2, 4));
	}

	@Test
	public void isP2Adventage4To3() throws Exception {
		assertEquals("adventage P2", board.getResult(3, 4));
	}

	@Test
	public void isP1Adventage4To3() throws Exception {
		assertEquals("adventage P1", board.getResult(4, 3));
	}

	@Test
	public void isP2New6Win() throws Exception {
		assertEquals("P1 wins game", board.getResult(4, 2));
	}

	@Test
	public void addToManyPointsToPlayer1() throws Exception {
		board.setPlayer1(4);
		board.setPlayer2(0);
		assertEquals(4, board.addPointsToPlayer(1));
	}

	@Test
	public void addToManyPointsToPlayer2() throws Exception {
		board.setPlayer1(2);
		board.setPlayer2(4);
		assertEquals(4, board.addPointsToPlayer(2));
	}

	@Test
	public void add5PointsToPlayer2() throws Exception {
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(1);
		assertEquals(4, board.addPointsToPlayer(2));
	}

	@Test
	public void isStillDeuce() throws Exception {
		board.player1 = 3;
		board.player2 = 3;
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		assertEquals("deuce", board.getResult(board.player1, board.player2));
	}

	@Test
	public void isP2Winnner() throws Exception {
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(2);
		assertEquals("P2 wins game",
				board.getResult(board.player1, board.player2));
	}

	@Test
	public void isPlayer2Has7Points() throws Exception {
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(1);
		board.addPointsToPlayer(2);
		board.addPointsToPlayer(2);
		assertEquals(7, board.player2);
	}
}
