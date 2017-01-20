package com.au.robot.action;

import com.au.robot.Face;
import com.au.robot.Robot;

/**
 * This action will move the robot one unit in the direction it is facing
 */
public class Move extends Action {

	/*
	 * (non-Javadoc)
	 * @see com.au.robot.action.Action#execute()
	 */
	@Override
	public boolean execute() {
		boolean isValidMove = false;
		state = Robot.getRobotState();
		if(null != state && null != state.getFace()){
			face = getDirectionofMove();
			getNextPosition();
			if(isNextPositionValid()){
				moveToNextPosition();
				isValidMove = true;
			} 
		}
		
		return isValidMove;
	}

	/**
	 * Get the direction in which the robot should move
	 * @return
	 */
	private Face getDirectionofMove() {
		return state.getFace();
	}
	
	/**
	 * Get the next position after moving the robot by one unit in its current direction
	 */
	private void getNextPosition(){
		switch(face){
		case EAST :
			y = state.getY();
			x = state.getX() + 1;
			break;
		case WEST :
			y = state.getY();
			x = state.getX() - 1;
			break;
		case NORTH :
			x = state.getX();
			y = state.getY() + 1;
			break;
		case SOUTH :
			x = state.getX();
			y = state.getY() - 1;
			break;
		}
	}
	
	/**
	 * Check if the new position is valid before moving the robot
	 * @return
	 */
	private boolean isNextPositionValid(){
		return positionValidator.validatePosition(x, y);
	}
	
	/**
	 * Set the new position as the robot state
	 */
	private void moveToNextPosition() {
			state.setX(x);
			state.setY(y);
	}
	
}
