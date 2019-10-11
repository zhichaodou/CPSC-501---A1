package test;

import org.junit.Assert;
import org.junit.Test;

import main.HighScore;
import map.Collidable;
import map.CollidableTester;
import map.MapObject;
import map.Player;

public class JunitTest {
	
	@Test
	public void checkCollidable( ) {
		boolean collision = true;
		Player testPlayer = new Player(6,7,10,11);
		CollidableTester collisionTest = new CollidableTester();
		collision = collisionTest.collisonCheck(testPlayer);
		Assert.assertFalse(collision);
	}  
	
	@Test
	public void checkMovement() {
		//int test;
		CollidableTester movementTest = new CollidableTester();
		movementTest.movement();
		//Assert.assertNotSame(null, movementTest.movement());
	}
	
	@Test
	public void checkpreviousHighScore() {
		
		int compairPrevHighScore = 218; //previous high score
		HighScore checkHS = new HighScore();
		int test = checkHS.previousHighScore();
		Assert.assertEquals(compairPrevHighScore, test); // check the previous high score which is current set at 218, this test will work if it can successfully get the high score
	}
	
	@Test
	public void checkCompairHighScore() {
		
		boolean testFalse = false;
		HighScore checkHSC = new HighScore();
		boolean runFalseTest = checkHSC.compareScores(); //by default, both user score and the current high score (without fetching the previous high score) are set to zero
														 //that being said, I expect it to be false
		Assert.assertEquals(testFalse, runFalseTest);
		
	}
	
	//Comment (below) this test out when testing checkpreviousHighScore ///////////////
	/*
	@Test
	public void checkWritingScore() {
		
		HighScore checkHSW = new HighScore();
		checkHSW.writeInNewScore();		// this test will be successful IF it writes a zero into the HighScores.txt
	}
	*/
	// Comment out (above) when not using /////////////////////////////////////////////
	
	@Test
	public void checkKeys() {
		
	}
	
}
