package com.comarch.tdd.tenis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kleko on 2014-05-23.
 */
public class TenisBoard {

	public static final String SCORE_SEPARATOR = " : ";
	public static final String PLAYER_WINS_GAME_SUFFIX = " wins games";
	public static final String PLAYER_WINS_GAME_PREFIX = "advantage ";
	public static final String DEUCE = "deuce";
	public static final String SECOND_PLAYER = "P2";
	public static final String FIRST_PLAYER = "P1";
	private int playerOneScore = 0;
	private int playerTwoScore = 0;

	private static final Map<Integer, String> pointsMapping = new HashMap<Integer, String>();

	public static final String LOVE = "love";

	public static final String FIFTEEN = "fifteen";

	public static final String THIRTY = "thirty";

	public static final String FOURTY = "fourty";

	static {
		pointsMapping.put(0, LOVE);
		pointsMapping.put(1, FIFTEEN);
		pointsMapping.put(2, THIRTY);
		pointsMapping.put(3, FOURTY);
	}

	public String getResult() {
		return playerHasMoreThenThirtyPoints() ? getResultForMoreThanThirtyPoints() : getRegularResult();
	}

	private String getRegularResult() {
		return convertScore(playerOneScore) + SCORE_SEPARATOR + convertScore(playerTwoScore);
	}

	private String getResultForMoreThanThirtyPoints() {
		String result = null;
		int diff = getPlayersDiff();
		if (diff == 0) {
			result = DEUCE;
		} else {
			result = getBetterPlayer(diff);
			result = Math.abs(diff) > 1 ? result + PLAYER_WINS_GAME_SUFFIX : PLAYER_WINS_GAME_PREFIX + result;
		}

		return result;
	}

	private int getPlayersDiff() {
		return playerOneScore - playerTwoScore;
	}

	private String getBetterPlayer(int diff) {
		return diff > 0 ? FIRST_PLAYER : SECOND_PLAYER;
	}

	private boolean playerHasMoreThenThirtyPoints() {
		return playerTwoScore > 3 || playerOneScore > 3;
	}

	public void addPoint(int playerNumber) throws CannotAddPointException {
		checkPlayerNumber(playerNumber);
		checkAddPoint(playerNumber);
		incrementScore(playerNumber);
	}

	private String convertScore(int points) {
		return pointsMapping.get(points);
	}

	private void checkAddPoint(int playerNumber) throws CannotAddPointException {
		int diff = getPlayersDiff() + (playerNumber == 1 ? 1 : -1);
		if (Math.abs(diff) > 4) {
			throw new CannotAddPointException();
		}
	}

	private void incrementScore(int playerNumber) {
		if (playerNumber == 1) {
			playerOneScore++;
		} else {
			playerTwoScore++;
		}
	}

	private void checkPlayerNumber(int playerNumber) {
		if (playerNumber < 1 || playerNumber > 2) {
			throw new InvalidPlayerNumberException();
		}
	}
}
