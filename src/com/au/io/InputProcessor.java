package com.au.io;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.au.robot.Robot;
import com.au.robot.controller.Command;
import com.au.robot.controller.RobotController;

/**
 * This class reads the commands in the file and processes them
 */
public class InputProcessor {
	
	private Logger LOG = Logger.getLogger(InputProcessor.class);
	
	
	/**
	 * This method reads the commands in the test file and processes them
	 * 
	 * @param toyRobot
	 * @param toyRobotController
	 * @param buffer
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("static-access")
	public void processInput(Robot toyRobot, RobotController toyRobotController, BufferedReader buffer)
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String line;
		while((line = buffer.readLine()) != null ){
			printToConsole(line);
			LOG.info(line);
			if(line.startsWith("#")) // Start of new test
				toyRobot.getRobotState().resetState();
			// Get Command from text
			Command command = toyRobotController.getCommandFromInput(line);
			if(Command.PLACE == command)
				toyRobotController.createCommandForRobot(toyRobot, line);
			else
				toyRobotController.createCommandForRobot(toyRobot, command);
		}
	}
	
	/**
	 * Display text on console
	 * 
	 * @param line
	 */
	private void printToConsole(String line){
		System.out.println(line);
	}

}
