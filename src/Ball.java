import java.awt.*;

/**
 * A Ball holds the data to represent
 * a Ball of varying size, position, speed,
 * and color. It can bounce and collide with
 * given boundaries.
 * @author Matthew Silva
 *
 */
public class Ball {
	
	/**
	 * The degree to which gravity affects the Ball
	 */
	private static final double GRAVITY_FACTOR = 0.1;

	/**
	 * Position of Ball on x axis
	 */
	private double x;
	
	/**
	 * Position of Ball on y axis
	 */
	private double y;
	
	/**
	 * x-component of Ball's velocity
	 */
	private double sX;
	
	/**
	 * y-component of Ball's velocity
	 */
	private double sY;
	
	/**
	 * Collision and render diameter of the Ball
	 */
	private int diameter;
	
	/**
	 * Color of the Ball
	 */
	private Color color;
	
	/**
	 * How much the Ball bounces vertically
	 */
	private double bounceFactor;
	
	/**
	 * Creates a Ball using the provided location, velocity, and diameter
	 * @param Position of Ball on x axis
	 * @param Position of Ball on y axis
	 * @param x-component of Ball's velocity
	 * @param y-component of Ball's velocity
	 * @param How much the Ball bounces vertically
	 * @param The diameter of the Ball
	 * @param The Color of the Ball
	 */
	public Ball(double x, double y, double sX, double sY, double bounceFactor,
			int diameter, Color color) {
		this.x = x;
		this.y = y;
		this.sX = sX;
		this.sY = sY;
		this.bounceFactor = bounceFactor;
		this.diameter = diameter;
		this.color = color;
	}
	
	/**
	 * Sets x position of Ball
	 * @param Desired position of Ball on x axis
	 */
	public void setX(double x) {
		this.x = x;
		
	}
	
	/**
	 * Sets y position of Ball
	 * @param Desired position of Ball on y axis
	 */
	public void setY(double y) {
		this.y = y;
		
	}
	
	/**
	 * Sets x-component of Ball's velocity
	 * @param Desired x-component of Ball's velocity
	 */
	public void setsX(double sX) {
		this.sX = sX;
		
	}
	
	/**
	 * Sets y-component of Ball's velocity
	 * @param Desired y-component of Ball's velocity
	 */
	public void setsY(double sY) {
		this.sY = sY;
		
	}
	
	/**
	 * @return Position of Ball on x axis
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @return Position of Ball on y axis
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Updates the Ball's position using its
	 * position and velocity.
	 * If the Ball will collide with the given
	 * boundaries, it will bounce instead of
	 * regularly updating its position, passing
	 * the offending boundary to a helper method.
	 */
	public void move(int left, int right, int bottom) {
		gravity();
		if (x + sX < left) {
			sideBounce(left);
		}
		else if (x + diameter + sX > right) {
			sideBounce(right);
		}
		else if (y + diameter + sY > bottom) {
			bottomBounce(bottom);
		}
		else {
			x = x + sX;
			y = y + sY;
		}
			
	}
	
	/**
	 * Applies gravity to the Ball, accelerating
	 * it downwards.
	 */
	private void gravity() {
		sY = sY + GRAVITY_FACTOR;
	}
	
	/**
	 * Reverses the y-component of the Ball's
	 * velocity when it bounces on the bottom of
	 * the box while losing some total velocity.
	 * Also specially updates the position of
	 * the Ball to account for the collision
	 * 
	 * @param The y coordinate of the bottom boundary
	 */
	private void bottomBounce(int bottom) {
		double pastTheBottom = y + sY + diameter - bottom;
		y = bottom - pastTheBottom - diameter;
		sY = (double) (sY * -bounceFactor);
	}
	
	/**
	 * Reverses the x-component of the Ball's
	 * velocity when it bounces on the bottom of
	 * the box while losing some total velocity.
	 * Also specially updates the position of
	 * the Ball to account for the collision with
	 * the given side.
	 * 
	 * @param The x coordinate of the side
	 * boundary collided with
	 */
	private void sideBounce(int side) {
		if (sX > 0) {
			double pastTheSide = x + sX + diameter - side;
			x = side - pastTheSide - diameter;
			 
			//x = x - ();
		}
		if (sX < 0) {
			double pastTheSide = x + sX - side;
			x = side + pastTheSide;
			 
			//x = x - ();
		}
		sX = sX * -1;
	}
	
	/**
	 * Sets the diameter of the Ball
	 * @param Desired diameter of the Ball
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
	/**
	 * Returns the diameter of the Ball
	 * @return Diameter of the Ball
	 */
	public int getDiameter() {
		return diameter;
	}
	
	/**
	 * Sets the Color of the Ball
	 * @param Desired color of the Ball
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Returns the Color of the Ball
	 * @return Color of the Ball
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Draws the Ball
	 * @param The Graphics object the Ball is drawn with
	 */
	public void Paint(Graphics pane) {
		pane.setColor(color);
		pane.fillOval((int) x, (int) y, diameter, diameter);
		pane.setColor(Color.black);
		pane.drawOval((int) x, (int) y, diameter, diameter);
		
		
	}
}
