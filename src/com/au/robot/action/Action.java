package com.au.robot.action;

import org.apache.log4j.Logger;

import com.au.robot.Face;
import com.au.robot.state.RobotState;
import com.au.validate.PositionValidation;

/**
 * This is the base action class for all the actions the robot can perform.
 */
public abstract class Action {
	
	protected int x = -1;
	protected int y = -1;
	protected Face face;
	protected RobotState state = null;
	protected Logger LOG = Logger.getLogger(Action.class);
	
	/**
	 * The validator to check that the position values are valid
	 */
	protected PositionValidation positionValidator = new PositionValidation();
	
	/**
	 * This is method will perform the action for the Robot.
	 * Valid actions are PLACE, MOVE, LEFT, RIGHT, REPORT
	 * 	
	 * @return
	 */
	public abstract boolean execute();


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
