package com.au.play;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.au.io.InputProcessor;
import com.au.io.RobotInputFileReader;
import com.au.robot.Robot;
import com.au.robot.controller.RobotController;

/**
 * This class creates a toy robot and sends it commands from a text file
 */
public class RobotSimulator {

	private static final Logger LOG = Logger.getLogger(RobotSimulator.class);
	
	/**
	 * Main method to simulate Toy robot
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Robot toyRobot = new Robot();
		
		try(BufferedReader buffer = new RobotInputFileReader().readTestIputFile("TestInput.txt")) {
			// Process the commands from the text file
			new InputProcessor().processInput(toyRobot, new RobotController(), buffer);
		
		} catch (IOException exception) {
			LOG.error("Invalid test input file");
			LOG.error(exception.toString());
		
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException exception) {
			LOG.error("Robot cannot act on invalid command");
			LOG.error(exception.toString());
		} 
	}

}
