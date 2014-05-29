/*package com.comarch.tdd;

import java.util.HashMap;
import java.util.Map;

import com.comarch.exception.GemFinishedException;

public class ResultHandler {

	private final static Map<Integer, String> scoreMap = new HashMap<Integer, String>() {
	};
	public static final String P1WINS = "P1 wins the game:)";
	public static final String P2WINS = "P1 wins the game:)";
	public static final String P1ADV = "advantage P1";
	public static final String P2ADV = "advantage P2";
	public static final String DEUCE = "deuce";
	

	static {
		scoreMap.put(0, "0");
		scoreMap.put(1, "15");
		scoreMap.put(2, "30");
		scoreMap.put(3, "40");
	}

	public int firstPlayerScore;
	public int secondPlayerScore;

	private int getAbsoluteDiff() {
		return Math.abs(firstPlayerScore - secondPlayerScore);
	}

	public String getActual() {
		if (firstPlayerScore < 3 && secondPlayerScore <= 3 || firstPlayerScore <= 3 && secondPlayerScore < 3)
			return scoreMap.get(firstPlayerScore) + "-" + scoreMap.get(secondPlayerScore);
		if (firstPlayerScore == secondPlayerScore)
			return DEUCE;
		//adv
		if (getAbsoluteDiff() == 1 && secondPlayerScore > firstPlayerScore)
			return P2ADV;
		else if (getAbsoluteDiff() == 1)
			return P1ADV;
		//win
		if (getAbsoluteDiff() >= 2 && firstPlayerScore > secondPlayerScore)
			return P1WINS;
		else
			return P2WINS;
	}

	private String getScore() {
		// TODO Auto-generated method stub
		return null;
	}

	public void checkGameOver() throws GemFinishedException {
		if (getAbsoluteDiff() >= 2 && (firstPlayerScore > 3 || secondPlayerScore > 3)) {
			throw new GemFinishedException("Game Over!");
		}
	}

	public void addFirstPlayerPoint() throws GemFinishedException {
		checkGameOver();
		firstPlayerScore++;
	}

	public void addSecondPlayerPoint() throws GemFinishedException {
		checkGameOver();
		secondPlayerScore++;
	}
}
*/