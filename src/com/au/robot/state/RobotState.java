package com.au.robot.state;

import org.apache.log4j.Logger;

import com.au.robot.Face;

/**
 * The class maintains the state of the robot and its current position
 */
public class RobotState {
	
	private int x = -1;
	private int y = -1;
	private Face face = null;
	private Logger LOG = Logger.getLogger(RobotState.class);
	
	/**
	 * Default constructor
	 */
	public RobotState() {	}
	
	/**
	 * Constructor creates a state with given position
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 */
	public RobotState(int x, int y, Face direction) {
		this.x = x;
		this.y = y;
		this.face = direction;
	}
	
	/**
	 * This method resets the state of the robot, placing it off the board
	 */
	public void resetState(){
		x = -1;
		y = -1;
		face = null;
	}
	
	/**
	 * Log the Robot's state
	 */
	public void logState() {
		LOG.info("Set position : X = " + x + ", Y = " + y + ", Face = " + face);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}
	
}
