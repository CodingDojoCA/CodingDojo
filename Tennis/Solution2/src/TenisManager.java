
public class TenisManager {

	private final int adv;
	
	private int score1;
	private int score2;
	
	public TenisManager(){
		adv = 2;
		score1 = 0;
		score2 = 0;
	}
	
	public Object checkScore() {
		String score;
		if ((score = isWin()) == null)
			score = checkNotWin(score);
		return score;
	}
	
	private String checkNotWin(String score) {
		if ((score = isDeuce()) == null)
			if ((score = isAdvantage()) == null)
				score = buildScore();
		return score;
	}
	
	public void addPoint(int player) {
		if(isWin() == null)
			if(player == 1) score1++;
			else if(player == 2)
				score2++;
	}
	
	private String buildScore() {
		String score = translateScore(score1);
		score += "-";
		score += translateScore(score2);
		return score;
	}

	private String translateScore(int score) {
		return score >= 4 ? null : Points.values()[score].toString();
	}

	private String isWin() {
		if(score1 >= 4 || score2 >=4)
			if(Math.abs(score1 - score2) >= adv)
				return "P" + (score1>score2 ? 1 : 2) + " wins game";
		return null;
	}
	
	private String isDeuce() {
		return (score1 > 2 && score2 >2 && score1 == score2) ? "deuce" : null;
	}
	
	private String isAdvantage() {
		if(translateScore(score1) == null || translateScore(score2) == null) {
			return "P" + (score1>score2?1:2) + " advantage";
		}
		return null;
	}
	
	private enum Points {
		love, fifteen, thirty, fourty;
	}
}
