package map;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Boost extends Collidable {
	private Image image;
	private boolean boosted = false;
  
	public Boost() {
		this(1630, 200, 60, 100);
	}

	public Boost(Obstacle obstacle) {
		this(obstacle.getXCoord() - 100, 200, 60, 100);
	}

	public Boost(int newX, int newY, int newHeight, int newWidth) {
		super(newX, newY, newHeight, newWidth);
		try {
			image = ImageIO.read(new File("src/images/Boost.png"));
		} catch(IllegalArgumentException iae){
			ErrorMessage.addError("Image is null in Boost");
		} catch (IOException ioe) {
			ErrorMessage.addError("Error reading image for Boost");
		}
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawImage(image, getXCoord(), getYCoord(), getWidth(), getHeight(), null);
	}

	@Override
	public void movement() {
		setX((int)(getXCoord() - getScroll()));
	}

	@Override
	public void collisionAction(Player player) {
		if(!boosted){
			player.boost();
			boosted = true;
		}
	}

}
