package map;


public abstract class Collidable extends MapObject {
	public Collidable() {
		this(0, 0, 50, 50);
	}

	public Collidable(int newX, int newY, int height, int width) {
		super(newX, newY, height, width);
	}

	/**
	 * Abstract method which controls what happens when a player collides with an object.
	 * Specific to each subclass.
	 */
	public abstract void collisionAction(Player player);

	/**
	* This method checks whether the player has collided with an object and calls collisionAction() accordingly.
	* @param player is the player whose location is being checked.
	*/
	public boolean collisonCheck(Player player) {
		boolean collision = false;
		int playerLeft = 70;
		int playerRight = 125;
		int playerTop = player.getYCoord();
		int playerBottom = player.getYCoord() + player.getHeight();
		int collidableObjectLeft = this.getXCoord();
		int collidableObjectRight = this.getXCoord() + this.getWidth();
		int collidableObjectTop = this.getYCoord();
		int collidableObjectBottom = this.getYCoord() + this.getHeight();
		
		if (this.checkLeftnRight(playerLeft, playerRight, collidableObjectLeft, collidableObjectRight) == true) {
			if(this.checkTopnBottom(playerTop, playerBottom, collidableObjectTop, collidableObjectBottom)) {
				collision = true;
			}
		}
		return collision;
	}
	
	public boolean checkLeftnRight(int playerLeft, int playerRight, int collidableObjectLeft, int collidableObjectRight) {
		if (((playerLeft >= collidableObjectLeft) && (playerLeft <= collidableObjectRight)) 
				|| ((playerRight >= collidableObjectLeft) && (playerRight <= collidableObjectRight))) {
			return true;
		}
		
		return false;
	}
	
	public boolean checkTopnBottom(int playerTop, int playerBottom, int collidableObjectTop, int collidableObjectBottom) {
		if (((playerTop >= collidableObjectTop) && (playerTop <= collidableObjectBottom))
				|| ((playerBottom >= collidableObjectTop) && (playerBottom <= collidableObjectBottom))) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public void movement() {
		setX((int)(getXCoord() - getScroll()));

	}
	
}
