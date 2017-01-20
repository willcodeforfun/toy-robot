package com.au.robot.controller;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.au.robot.Face;
import com.au.robot.Robot;

/**
 * This class the controller that sends the commands to the robot
 */
public class RobotController {

	private Logger LOG = Logger.getLogger(RobotController.class);

	/**
	 * This method gets the command from the input text
	 * 
	 * @param input
	 * @return
	 */
	public Command getCommandFromInput(String input) {
		Command command = null;
		StringTokenizer tokeniser = new StringTokenizer(input);
		command = (tokeniser.hasMoreTokens()) ? Command.getCommandByName(tokeniser.nextToken()) : null;
		return command;
	}

	/**
	 * This method creates the command with the positions if required to be sent to the robot
	 * 
	 * @param robot
	 * @param input
	 * @return
	 * @throws NumberFormatException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public boolean  createCommandForRobot(Robot robot, String input)
			throws NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		StringTokenizer commandSeperator = new StringTokenizer(input);
		commandSeperator.nextToken();
		StringTokenizer positionSeperator = new StringTokenizer(commandSeperator.nextToken(), ",");
		int x = getIntValue(positionSeperator);
		int y = getIntValue(positionSeperator);
		Face face = Face.getFaceByName((positionSeperator.hasMoreTokens()) ? positionSeperator.nextToken().toUpperCase() : "");
		LOG.info("Place positions are : " + x + ", " + y);
		 return new ActionGenerator().performAction(robot, Command.PLACE, x, y, face);
	}

	/**
	 * Extract the position for the robot from input text
	 * 
	 * @param positionSeperator
	 * @return
	 */
	private Integer getIntValue(StringTokenizer positionSeperator) {
		return Integer.valueOf((positionSeperator.hasMoreTokens()) ? isNumber(positionSeperator.nextToken()): "-1");
	}

	/**
	 * This method invokes the Action generator to create an action for the command
	 * 
	 * @param robot
	 * @param command
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public boolean createCommandForRobot(Robot robot, Command command)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return new ActionGenerator().performAction(robot, command);
	}
	
	/**
	 * Check if the text is numeric
	 * 
	 * @param text
	 * @return
	 */
	private String isNumber(String text){
			return (text.matches("\\d*")) ? text : "-1";
	}

}
