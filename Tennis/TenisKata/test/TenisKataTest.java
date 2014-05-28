import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TenisKataTest {

	TenisManager manager;
	
	@Before
	public void init(){
		manager = new TenisManager();
	}
	
	@Test
	public void isLoveAfterInit() {
	    Assert.assertEquals("love-love", manager.checkScore());
	}

	@Test
	public void addPointForPlayer1() {
		manager.addPoint(1);
	    Assert.assertEquals("fifteen-love", manager.checkScore());
	}

	@Test
	public void addPointForPlayer2() {
		manager.addPoint(2);
	    Assert.assertEquals("love-fifteen", manager.checkScore());
	}

	@Test
	public void detectDuce() {
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(2);
	    Assert.assertEquals("deuce", manager.checkScore());
	}
	
	@Test
	public void player1WinsWhenScore4InARow() {
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
	    Assert.assertEquals("P1 wins game", manager.checkScore());
	}
	
	@Test
	public void player2WinsWithAdvantage() {
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(1);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(2);
	    Assert.assertEquals("P2 wins game", manager.checkScore());
	}
	
	@Test
	public void player1Wins() {
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(2);
	    Assert.assertEquals("P1 wins game", manager.checkScore());
	}
	
	@Test
	public void player2Wins() {
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
	    Assert.assertEquals("P2 wins game", manager.checkScore());
	}
	
	@Test
	public void player1Advantage() {
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(1);
	    Assert.assertEquals("P1 advantage", manager.checkScore());
	}
	
	@Test
	public void player1WinAfterAdvantage() {
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(1);
		manager.addPoint(1);
	    Assert.assertEquals("P1 wins game", manager.checkScore());
	}
	
	@Test
	public void player2Advantage() {
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(1);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(2);
		manager.addPoint(1);
		manager.addPoint(2);
		manager.addPoint(2);
	    Assert.assertEquals("P2 advantage", manager.checkScore());
	}
	
}
