package state;

import main.Manager;
import music.MusicPlayer;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class MenuState implements GameState {
	private BufferedImage image,start,scores,credits,exit,keyMap;
	private Manager manager;
	private MusicPlayer music;
	
	public MenuState(Manager manager) {
		try {
			image = ImageIO.read(new File("src/images/background.png"));
			start = ImageIO.read(new File("src/images/startGameIcon.png"));
			scores = ImageIO.read(new File("src/images/Scores.png"));
			credits = ImageIO.read(new File("src/images/Credits.png"));
			exit = ImageIO.read(new File("src/images/title1.png"));
			keyMap = ImageIO.read(new File("src/images/keyMapNew.png"));
		} catch(IOException e ) {
			e.printStackTrace();
		}
		this.manager = manager;
		music = new MusicPlayer("src/music/BirdRunFullnew.wav");
		music.play(true);
	}
	
	public void update(){
		if(!(music.playing())){
			music.play(true);
		}
	}

	public void draw(Graphics2D graphics) {
	    graphics.drawImage(image, 0, 0,1650, 550, null);      
	    graphics.drawImage(start, 650, 100, null);  
	    graphics.drawImage(scores, 650, 200, null);
	    graphics.drawImage(credits, 650, 300, null);
	    graphics.drawImage(exit, 540, 0, null);
	    graphics.drawImage(keyMap, 600, 130,null);

	}
	
	public void keyPressed(int key){
		
		int button = 0;
		
		if(key == KeyEvent.VK_P){
			//music.stop();
			//manager.setState(manager.getState("PLAY"));
			button = 1;
		}else if(key == KeyEvent.VK_C){
			//manager.setState(manager.getState("CREDIT"));
			button = 2;
		}else if(key == KeyEvent.VK_E){
			//manager.setState(manager.getState("EXIT"));
			button = 3;
		}else if(key == KeyEvent.VK_S){
			//manager.setState(manager.getState("SCORES"));
			button = 4;
		}
		
		switch(button) {
		
		case 1:
			music.stop();
			manager.setState(manager.getState("PLAY"));
			break;
			
		case 2:		
			manager.setState(manager.getState("CREDIT"));
			break;
			
		case 3:	
			manager.setState(manager.getState("EXIT"));
			break;
			
		case 4:	
			manager.setState(manager.getState("SCORES"));
			break;
		}
		
		
	}
	
}
