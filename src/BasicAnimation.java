/*
	Author:	Gaston
							B a s i c   a n i m a t i o n
							=============================
	Description:

		This program illustrates basic animation in Java.

		The program paints an applet in one of two possible states.  The state
			changes under the control of an independent "Thread."
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/**
 * BasicAnimation allows for the creation of
 * an Applet with Buttons to perform various
 * actions on the BallOrganizer animation
 * within the Applet
 * 
 * @author Matthew Silva
 *
 */
public class BasicAnimation extends Applet implements ActionListener
{	
	/**
	 * Organizes the collection of Balls
	 * and allows manipulation
	 */
	private BallOrganizer ballOrganizer;					//	We need an animated object

	/**
	 * Initializes the applet and creates buttons with
	 * their associated action listeners
	 */
	public void init()
	{
		ballOrganizer = new BallOrganizer(this);			//	We instantiate the "watch"
		Button Reset = new Button("Reset");
		Button Slower = new Button("Slower");
		Button Faster = new Button("Faster");
		Button Throw = new Button("Throw");
		Button Remove = new Button("Remove");
		
		add(Reset);
		add(Slower);
		add(Faster);
		add(Throw);
		add(Remove);
		
		Reset.addActionListener(this);
		Slower.addActionListener(this);
		Faster.addActionListener(this);
		Throw.addActionListener(this);
		Remove.addActionListener(this);
	}
	
	/**
	 * Adds functions to the buttons for when
	 * they are clicked
	 */
	public void actionPerformed(ActionEvent clicked) {
			
			String action = clicked.getActionCommand();
			
			if (action.equals("Reset")) { //Removes all Balls
				ballOrganizer.clearBalls();
				ballOrganizer.resetPeriod();
			}
			if (action.equals("Slower"))//Slows the animation's speed
				ballOrganizer.periodChange(2);
			if (action.equals("Faster"))//Increases the animation's speed
				ballOrganizer.periodChange(-2);
			if (action.equals("Throw")) { //Creates a new thrown Ball
				ballOrganizer.addThrownBall();
				ballOrganizer.resetPeriod();
			}
			
			if (action.equals("Remove"))//Removes a random Ball
				ballOrganizer.removeRandom();
		
	}

	/**
	 * Paints the applet with a pink background,
	 * as well as the BallsOrganizer if it is
	 * not null
	 */
	public void paint(Graphics pane)
	{
		setBackground(Color.pink);

		if (ballOrganizer != null)	
			ballOrganizer.paint(pane);
	}
}
