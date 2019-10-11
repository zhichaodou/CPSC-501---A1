package main;

import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
    	/* Create the instance variables needed to run the game */
	    GameWindow gameWindow = new GameWindow();
	
	    // Setting the frame environment
	    JFrame frame = new JFrame("Happy Bird");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1650, 550);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
	    frame.setAlwaysOnTop(false);
	    frame.setVisible(true);
		frame.setContentPane(gameWindow);

     
	}
}
