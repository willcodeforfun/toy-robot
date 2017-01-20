package com.au.io;

import org.apache.log4j.Logger;

import com.au.robot.Robot;
import com.au.validate.PositionValidation;

/**
 * This class displays the Robot's state to console
 */
public class OutputProcessor {
	
	private Logger LOG = Logger.getLogger(RobotInputFileReader.class);
	
	/**
	 * This method displays the state of Robot to console
	 * 
	 * @return
	 */
	public boolean displayOutput(){
		boolean isDisplaySuccess = false;
		if(null != Robot.getRobotState()){
			LOG.info(Robot.getRobotState().toString());
			printToConsole();
			isDisplaySuccess = true;
		}
		return isDisplaySuccess;
		
	}
	
	/**
	 * This method prints text to console
	 */
	private void printToConsole(){
		System.out.print("Output : ");
		if(new PositionValidation().validatePosition(Robot.getRobotState().getX(), Robot.getRobotState().getY()))
			System.out.println(Robot.getRobotState().getX() + ", "
				+Robot.getRobotState().getY() + ", "
				+Robot.getRobotState().getFace());
		else
			System.out.println("Robot not on board");
	}

}
