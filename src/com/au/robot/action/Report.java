package com.au.robot.action;

import static com.au.robot.Robot.getRobotState;

import com.au.io.OutputProcessor;

/**
 * This action will report the current state of the Robot
 */
public class Report extends Action {

	/*
	 * (non-Javadoc)
	 * @see com.au.robot.action.Action#execute()
	 */
	@Override
	public boolean execute() {
		boolean isValid = false;
		if(null != getRobotState()){
			isValid = true;
			reportPosition();
		}
		return isValid;
	}

	/**
	 * Display the robot's state and log it 
	 */
	private void reportPosition() {
		new OutputProcessor().displayOutput();
		LOG.info("(X , Y) = (" + getRobotState().getX() + " , " + getRobotState().getY() 
								+ ") Face = " + getRobotState().getFace());
	}
}
