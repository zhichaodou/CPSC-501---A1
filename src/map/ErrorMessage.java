package map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;



public class ErrorMessage extends MapObject {
	private static ArrayList<String> errors = new ArrayList<String>();
	
	public ErrorMessage() {
		super(0, 500);
	}

	/**
	 * This method adds a message to the errors array list.
	 * @param message is the message which is being added.
	 */
	public static void addError(String message) {
		errors.add(message);
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		int distance = 0;
		graphics.setColor(Color.RED);
		for(String message : errors) {
			graphics.drawString(message, 0 + distance, 10);
			distance += 50;
		}
	}

	@Override
	public void movement() {
		// The error message does not need to move across the screen, so this method does not do anything.
	}

	@Override
	public boolean collisonCheck(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

}
