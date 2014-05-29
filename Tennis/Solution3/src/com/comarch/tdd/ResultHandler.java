package com.comarch.tdd;

import java.util.HashMap;
import java.util.Map;

import com.comarch.exception.GemFinishedException;
/**
 * @author tomek
 *
 */
public class ResultHandler {

	private final static Map<Integer, String> scoreMap = new HashMap<Integer, String>() {
	};

	static {
		scoreMap.put(0, "0");
		scoreMap.put(1, "15");
		scoreMap.put(2, "30");
		scoreMap.put(3, "40");
	}

	public int firstPlayerScore;
	public int secondPlayerScore;

	public String getActual() {
		int diff = firstPlayerScore - secondPlayerScore;
		return getScore() + getDeuce(diff) + getAdvantage(diff) + getWin(diff);
	}

	private String getDeuce(int diff) {
		if (firstPlayerScore == secondPlayerScore && secondPlayerScore >= 3)
			return "deuce";
		return "";
	}

	private String getScore() {
		if ((secondPlayerScore <= 3 && firstPlayerScore < 3) || (secondPlayerScore < 3 && firstPlayerScore <= 3))
			return scoreMap.get(firstPlayerScore) + "-" + scoreMap.get(secondPlayerScore);
		return "";
	}

	private String getAdvantage(int diff) {
		if (Math.abs(diff) == 1 && (secondPlayerScore > 3 || firstPlayerScore > 3))
			return firstPlayerScore > 3 ? "advantage P1" : "advantage P2";
		return "";
	}

	private String getWin(int diff) {
		if (Math.abs(diff) >= 2 && (secondPlayerScore > 3 || firstPlayerScore > 3))
			return firstPlayerScore > secondPlayerScore ? "P1 wins the game:)" : "P2 wins the game:)";
		return "";
	}

	public void checkGameOver() throws GemFinishedException {
		if (Math.abs(firstPlayerScore - secondPlayerScore) >= 2 && (firstPlayerScore > 3 || secondPlayerScore > 3))
			throw new GemFinishedException("Game Over!");
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
