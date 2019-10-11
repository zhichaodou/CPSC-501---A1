package test;

import org.junit.Assert;
import org.junit.Test;

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
	public void checkHighScore() {
		
	}
	
	@Test
	public void checkKeys() {
		
	}
	
}
