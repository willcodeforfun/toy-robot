package com.au.robot.action;

import com.au.robot.Face;
import com.au.robot.Robot;

/**
 * This class will turn the Robot toward the left direction but will not move the robot.
 */
public class Left extends Action {

	/*
	 * (non-Javadoc)
	 * @see com.au.robot.action.Action#execute()
	 */
	@Override
	public boolean execute() {
		boolean isMovedLeft = false;
		state = Robot.getRobotState();
		if(null != state && null != state.getFace()) {
			face = moveFaceLeft();
			setNewDirectioninState(face);
			isMovedLeft = true;
		}
		return isMovedLeft;
	}

	/**
	 * This method checks the current state of the robot and 
	 * determines the new direction after turning the robot to left.
	 * 
	 * @return
	 */
	private Face moveFaceLeft(){
		Face newDirection = null;
		switch(state.getFace()) {
		case EAST :
			newDirection = Face.NORTH;
			break;
		case WEST : 
			newDirection = Face.SOUTH;
			break;
		case NORTH :
			newDirection = Face.WEST;
			break;
		case SOUTH :
			newDirection = Face.EAST;
			break;
		}
		return newDirection;
	}
	
	/**
	 * Set the new direction in the Robot state
	 * 
	 * @param newDirection
	 */
	private void setNewDirectioninState(Face newDirection){
		Robot.getRobotState().setFace(newDirection);
	}
}
