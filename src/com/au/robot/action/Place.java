package com.au.robot.action;

import com.au.robot.Robot;
import com.au.robot.state.RobotState;

/**
 * This action places the robot on the board at the given position
 */
public class Place extends Action {

	/*
	 * (non-Javadoc)
	 * @see com.au.robot.action.Action#execute()
	 */
	@Override
	public boolean execute() {
		boolean isRobotPlaced = false;
		// Validate if the given position is valid
		if(positionValidator.validatePosition(x, y) && null != face){
			state = new RobotState(x, y, face);
			// Set the position as the robot's state
			Robot.setRobotState(state);
			isRobotPlaced = true;
		} else {
			LOG.error("Missing or Invalid position for placing Robot on board");
			isRobotPlaced = false;
		}
		return isRobotPlaced;
	}

}
