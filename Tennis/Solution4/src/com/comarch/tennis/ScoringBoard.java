package com.comarch.tennis;

public class ScoringBoard {

	int player1;
	int player2;
	
	public ScoringBoard(int player1, int player2){
		this.player1 = player1;
		this.player2 = player2;
	}
	

	public int addPointsToPlayer(int player) {
		if (getResult(player1, player2) == "P1 wins game"
				|| getResult(player1, player2) == "P2 wins game") {
			if (player == 1)
				return player1;
			else
				return player2;
		} else if (player == 1 && getResult(player1, player2) == "P1 wins game")
			return player1;
		
		else if (player == 2 && getResult(player1, player2) == "P2 wins game") {
			return player2;
		} else
			return extracted(player);
	}


	private int extracted(int player) {
		if (player == 1)
			return ++player1;
		else
			return ++player2;
	}

	

	

	private boolean isPlayerOneWins(int player) {
		return player == 1 && getResult(player1, player2) == "P1 wins game";
	}


	private boolean isGameOverForPlayerOneOrPlayerTwo() {
		return getResult(player1, player2) == "P1 wins game"
				|| getResult(player1, player2) == "P2 wins game";
	}

	public String getResult(int a, int b) {
		if (a == 0 && b == 0) {
			return "love-love";
		} else if (a == 0 && b == 1) {
			return "love-fifteen";
		} else if (a == 1 && b == 0) {
			return "fifteen-love";
		} else if (a == 1 && b == 1) {
			return "fifteen-fifteen";
		} else if (a == 1 && b == 2) {
			return "fifteen-thirty";
		} else if (a == 1 && b == 3) {
			return "fifteen-fourty";
		} else if (a == 2 && b == 0) {
			return "thirty-zero";
		} else if (a == 2 && b == 2) {
			return "thirty-thirty";
		} else if (a == 2 && b == 1) {
			return "thirty-fifteen";
		} else if (a == 2 && b == 3) {
			return "thirty-fourty";
		} else if (a == 3 && b == 0) {
			return "forty-love";
		} else if (a == 3 && b == 1) {
			return "forty-fifteen";
		} else if (a == 3 && b == 2) {
			return "forty-thirty";//
		} else if (a == b && a >= 3 && b >= 3) {
			return "deuce";
		} else if (a > 3 && a > b && a == b + 1) {
			return "adventage P1";
		} else if (b > 3 && b > a && b == a + 1) {
			return "adventage P2";
		} else if (a > 3 && a > b + 1) {
			return "P1 wins game";
		} else if (b > 3 && b > a + 1) {
			return "P2 wins game";
		}
		return "";
	}

	public int getPlayer1() {
		return player1;
	}

	public void setPlayer1(int player1) {
		this.player1 = player1;
	}

	public int getPlayer2() {
		return player2;
	}

	public void setPlayer2(int player2) {
		this.player2 = player2;
	}

}
