import java.awt.*;

import java.applet.Applet;

/**
 * The BallOrganizer holds and animates a Collection 
 * of Balls within an Applet.
 * It allows manipulation of the Collection,
 * including throwing Balls, removing Balls, 
 * clearing all the Balls, and animating the
 * Balls
 * 
 * It also handles the instantiation and configuration
 * of an Alarm, including setting its speed
 * 
 * @author Matthew Silva 
 *
 */
public class BallOrganizer implements AlarmListener
{
	/**
	 * The initial sleeping period of the Alarm
	 */
	private static final int INITIAL_PERIOD = 40;
	
	/**
	 * Stores the Applet associated with the main program
	 */
	private Applet theApplet;

	/**
	 * Declares the Alarm used to time the animation
	 */
	private Alarm alarm;

	/**
	 * Declares the Collection of Balls 
	 * as type CollectionInterface
	 */
	private CollectionInterface<Ball> balls;
	
	/**
	 * The desired diameter of the Balls
	 */
	private int diameter = 30;
	
	/**
	 * How bouncy the Balls should be
	 */
	private double bounceFactor = 0.95;
	
	
	/**
	 * x coordinate of the left boundary
	 */
	private int left = 15;
	
	/**
	 * x coordinate of the right boundary
	 */
	private int right = 500;
	
	/**
	 * y coordinate of the top of the Applet
	 */
	private int top = 0;
	
	/**
	 * y coordinate of the bottom boundary
	 */
	private int bottom = 400;

	
	/**
	 * Current sleep period of the Alarm in milliseconds
	 */
	private int alarmPeriod = INITIAL_PERIOD;
	

	/**
	 * Default Constructor that initializes and
	 * configures only the Alarm and Collection of the 
	 * BallOrganizer for non-graphic uses
	 */
	public BallOrganizer()
	{
		balls = new Collection<Ball>();
		
		alarm = new Alarm("Beep", this);	//	We "create" an alarm
		alarm.start();						//		and we get it started
		alarm.setPeriod(alarmPeriod);
	}

	/**
	 * Constructor that instantiates the
	 * BallOrganizer with an Applet as well as 
	 * initializing and configuring the
	 * Alarm and Collection
	 * @param The Applet BallOrganizer is being used with
	 */
	public BallOrganizer(Applet mainProgram)
	{
		balls = new Collection<Ball>();
		theApplet = mainProgram;
		
		alarm = new Alarm("Beep", this);	//	We "create" an alarm
		alarm.start();						//		and we get it started
		alarm.setPeriod(alarmPeriod);

	}
			
	/**
	 * Tells the Collection to clear itself
	 */
	public void clearBalls() {
		balls.clear();
	}
	
	/**
	 * Changes the sleep period of the Alarm
	 * @param Desired integer change in timing,
	 * negative for decrease, positive for increase.
	 * The sleep period cannot go below zero.
	 */
	public void periodChange( int change ) {
		if (alarmPeriod + change > 0) {
			alarmPeriod = alarmPeriod + change;
			alarm.setPeriod(alarmPeriod);
		}
		else
			System.out.println("Speed at minimum");
	}
	
	/**
	 * Creates a Ball with somewhat
	 * random characteristics and adds
	 * it to the Collection
	 */
	public void addThrownBall() {
		// Set x to the middle plus a random portion of one fifth
		// the box's horizontal length
		int x = (int) ((right + left)/2 + Math.random()*(right+left)/5);
		
		// Set y to the bottom minus two times the Ball's diameter minus a random portion
		// of half the vertical length of the box
		int y = (int) (bottom - Math.random()*bottom/2 - diameter*2 );
		
		// Set the x speed to a random positive or negative value
		int sX = (int) ((Math.random()*3 + 2)*((int) (Math.random()*2)*2 - 1));
		
		// Set the y speed to a random positive value
		int sY = (int) (Math.random()*2 + 1);
		
		Color color = randomColor();
		Ball thrown = new Ball(x, y, sX, sY, bounceFactor, diameter, color);
		balls.add(thrown);
	}
	
	/**
	 * @return A random Color
	 */
	private Color randomColor() {
		return new Color(
				(float) Math.random(),
				(float) Math.random(),
				(float) Math.random());
	}
	
	/**
	 * Resets the Alarm sleep period to the initial value
	 */
	public void resetPeriod() {
		alarmPeriod = INITIAL_PERIOD;
		alarm.setPeriod(alarmPeriod);
	}
	
	/**
	 * If the Collection of Balls is not
	 * empty, tell it to remove a random Ball
	 * @throws IllegalStateException if the Collection
	 * is empty
	 */
	public void removeRandom() throws IllegalStateException{
		if(!balls.isEmpty())
			balls.removeRandom();
		else
			System.out.println("Collection is Empty");
	}

//
//	In order to use an alarm, we need to provide a takeNotice method.
//	It will be invoked each time the alarm goes off.
//
	/**
	 * Invoked every time the
	 * Alarm goes off
	 * Moves the Balls and then repaints the Applet
	 */
	public void takeNotice()
	{
		moveBalls();		
		
		theApplet.repaint();
	}
	
	/**
	 * Moves every Ball in the Collection
	 */
	private void moveBalls() {
		for (int g = 0; g < balls.size(); g++)
		{
			balls.get(g).move(left, right, bottom);
		}
	}
	
//
//	The only "graphical" method of the class is the paint method.
//
	/**
	 * Paints the Balls and the boundaries
	 * @param The Graphics Object drawn on
	 */
	public void paint(Graphics pane)
	{

		paintBalls(pane);
		paintBoundaries(pane);
	}
	
	/**
	 * Paints each Ball in the Collection
	 * @param The Graphics Object drawn on
	 */
	private void paintBalls(Graphics pane) {
		for (int g = 0; g < balls.size(); g++)
		{
			balls.get(g).Paint(pane);
		}
	}
	
	/**
	 * Paints the boundaries
	 * @param The Graphics Object drawn on
	 */
	private void paintBoundaries(Graphics pane) {
		pane.drawLine(left, top, left, bottom);
		pane.drawLine(left, bottom, right, bottom);
		pane.drawLine(right, bottom, right, top);
		pane.setColor(Color.black);
	}



}	//	end of class TicTac
