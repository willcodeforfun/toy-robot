package com.au.robot.controller;

import org.apache.log4j.Logger;

import com.au.robot.Face;
import com.au.robot.Robot;
import com.au.robot.action.Action;
import com.au.robot.action.Place;

/**
 *  This class maps the command and the corresponding action for the Robot
 */
public class ActionGenerator {
	
	private Logger LOG = Logger.getLogger(ActionGenerator.class);
	
	/**
	 * This method finds the corresponding action for the command.
	 * Then performs the action for the robot. 
	 * 
	 * @param robot
	 * @param command
	 * @param placePositions
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public boolean performAction(Robot robot, Command command, Object...placePositions)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		boolean isActionComplete = false;

		if (null != command) {
			Action action = createActionFromCommand(command.getCommandName(), placePositions);
			sendActionToRobot(robot, action);
			performAction(robot);
			isActionComplete = true;
		} else {
			isActionComplete = false;
			LOG.info("Invalid command. Robot ignores it");
		}

		return isActionComplete;
	}

	/**
	 * This method creates the action from the command
	 * 
	 * @param commandName
	 * @param placePositions
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	private Action createActionFromCommand(String commandName, Object...placePositions)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Action action = ((Class<Action>) Class.forName("com.au.robot.action." + commandName)).newInstance();
		 if(action instanceof Place) {
			 action.setX((Integer)placePositions[0]);
			 action.setY((Integer)placePositions[1]);
			 action.setFace((Face)placePositions[2]);
		 }
		 return action;
	}

	/**
	 * This method sends the action to the robot
	 * 
	 * @param robot
	 * @param action
	 */
	private void sendActionToRobot(Robot robot, Action action) {
		robot.setAction(action);
	}

	/**
	 * This method performs the action for the robot
	 * 
	 * @param robot
	 */
	private void performAction(Robot robot) {
		robot.getAction().execute();
	}

}
