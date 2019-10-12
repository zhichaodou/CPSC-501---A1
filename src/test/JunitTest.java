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
	
	@Test // make sure cehckWiringScore isn't being tested when testing this one
	public void checkpreviousHighScore() {
		
		int compairPrevHighScore = 218; //previous high score
		int currentScore =0;
		HighScoreData checkHS = new HighScoreData();
		int test = checkHS.getPreviousHighScore(currentScore);
		Assert.assertEquals(compairPrevHighScore, test);
	}
	
	@Test
	public void checkCompairHighScore() {
		
		boolean testFalse = true;
		int testUser = 10;
		int testPreviousBest = 5;
		HighScoreData checkHSC = new HighScoreData();
		boolean runFalseTest = checkHSC.compareScores(testUser,testPreviousBest); //after refractor, we want to see if the user score can indeed be replaced by the user score
																				  //
		Assert.assertEquals(testFalse, runFalseTest);
		
	}
	
	//Comment (below) this test out when testing checkpreviousHighScore ///////////////
	/*
	@Test
	public void checkWritingScore() {
		
		int testNewHS = 150;
		HighScoreData checkHSW = new HighScoreData();
		checkHSW.writeInNewScore(testNewHS);		// this test will be successful IF it writes a zero into the HighScores.txt
	}
	*/
	// Comment out (above) when not using /////////////////////////////////////////////
	
	@Test
	public void checkKeys() {
		
	}
	
}
