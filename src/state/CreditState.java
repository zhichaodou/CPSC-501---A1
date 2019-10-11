package state;

import main.Manager;
import map.ErrorMessage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;



public class CreditState implements GameState {
	private Manager Manager;
	private BufferedImage cbGround, ZachBlach;
	private String TeamMembers[];
	private String Titles[];
	private String Sources[];
	private Font TFont;
	private Font TiFont;
	private Color Col = Color.decode("#3A8EF2");
	
	public CreditState(Manager manager){
		this.Manager = manager;
		TeamMembers = new String[] { "Dou, Zhi Chao", "Flanagan, Emily", "Khelif, Haithem","Schijins, Josh","Tieu, Katie"};
		Titles = new String[] {"Credits","Team Members","Art / Sounds"};
		Sources = new String[] {"freesound.org","opengameart.org","DJ Zach Blach"};
		TFont = new Font ("Courier New", 1, 20);
		TiFont = new Font ("SansSerif.bold", 1, 50);
		
		try {
			cbGround = ImageIO.read(new File("src/images/background.png"));
			ZachBlach = ImageIO.read(new File("src/images/DjZachBlach.png"));
		} catch(IllegalArgumentException iae) {
			ErrorMessage.addError("Image is null in Credits");
		} catch (IOException ioe) {
			ErrorMessage.addError("Error reading image for Credits");
		}
	}

	@Override
	public void update() {
		// The credits do not need to change once displayed, so this method does not do anything.
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawImage(cbGround, 0,0,1650, 550, null);
		graphics.drawImage(ZachBlach, 1000, 200, 500,375,null);
		graphics.setColor(Col);
		graphics.setFont(TFont);
		graphics.drawString(Titles[0],700, 50);
		graphics.drawString(Titles[1],630, 140);
		graphics.setFont (TFont);
		for (int i=0; i < 5; i++) {
			graphics.setColor(Color.BLACK);
			graphics.drawString(TeamMembers[i],720, 190+ i*25);
			}
		graphics.setColor(Col);
		graphics.setFont(TiFont);
		graphics.drawString(Titles[2],650, 350);
		graphics.setFont(TiFont);
		for (int i=0; i <= 2; i++) {
			graphics.setColor(Color.BLACK);
			graphics.drawString(Sources[i],700, 400+ i*25);
			}
	}

	@Override
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_R){
			Manager.setState(Manager.getState("MENU"));
		}

	}

}
