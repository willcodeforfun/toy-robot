package com.au.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.au.robot.Robot;
import com.au.robot.controller.RobotController;

import junit.framework.TestCase;

/**
 * Test for the Input processor
 *
 */
public class InputProcessorTest extends TestCase{
	
	Robot robot = new Robot();
	RobotController controller = new RobotController();
	RobotInputFileReader input = new RobotInputFileReader();
	BufferedReader reader = null;
	
	@Before
	public void setUp(){
		try {
			reader = input.readTestIputFile("TestInput.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected=IOException.class)
	public void testValidInput() throws IOException{
		try {
			new InputProcessor().processInput(robot, controller, reader);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
}
