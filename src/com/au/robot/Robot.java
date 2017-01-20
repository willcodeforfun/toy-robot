package com.au.robot;

import org.apache.log4j.Logger;

import com.au.robot.action.Action;
import com.au.robot.state.RobotState;
import com.au.validate.PositionValidation;

/**
 * This is the Toy- Robot. It has a state and can perform actions based on commands. 
 * The actions can change the state of the robot
 */
public class Robot {
	
	private static RobotState ROBOT_STATE;
	private Action action;
	private Logger LOG = Logger.getLogger(Robot.class);
	
	public Robot(){
		ROBOT_STATE = new RobotState();
		action = null;
	}
	
	/**
	 * This method sets the position as the state of the robot
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 * @return
	 */
	public boolean setPosition(int x, int y, Face direction) {
		boolean isValid = false;
		if (new PositionValidation().validatePosition(x, y)) {
			ROBOT_STATE = new RobotState(x, y, direction);
			logPosition();
			isValid = true;
		}
		return isValid;
	}
	
	/**
	 * Log state of the robot
	 */
	private void logPosition(){
		LOG.info("Robot is in a valid state");
		ROBOT_STATE.logState();
	}
	
	public static RobotState getRobotState() {
		return ROBOT_STATE;
	}
	
	public static void setRobotState(RobotState state) {
		ROBOT_STATE = state;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}
