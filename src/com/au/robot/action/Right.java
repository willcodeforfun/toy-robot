package com.au.robot.action;

import com.au.robot.Face;
import com.au.robot.Robot;

/**
 * This action turns the robot in right direction without moving the robot
 */
public class Right extends Action {

	/*
	 * (non-Javadoc)
	 * @see com.au.robot.action.Action#execute()
	 */
	@Override
	public boolean execute() {
		boolean isMovedRight = false;
		state = Robot.getRobotState();
		if(null != state && null != state.getFace()) {
			face = moveFaceRight();
			setNewDirectioninState(face);
			isMovedRight = true;
		}
		return isMovedRight;
	}

	/**
	 * This method will determine the new direction of the robot
	 * @return
	 */
	private Face moveFaceRight(){
		Face newDirection = null;
		switch(state.getFace()) {
		case EAST :
			newDirection = Face.SOUTH;
			break;
		case WEST : 
			newDirection = Face.NORTH;
			break;
		case NORTH :
			newDirection = Face.EAST;
			break;
		case SOUTH :
			newDirection = Face.WEST;
			break;
		}
		return newDirection;
	}
	
	/**
	 * This method will save the new direction of the robot as the Robot's state
	 * @param newDirection
	 */
	private void setNewDirectioninState(Face newDirection){
		Robot.getRobotState().setFace(newDirection);
	}
}
