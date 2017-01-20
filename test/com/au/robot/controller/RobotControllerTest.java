package com.au.robot.controller;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.au.robot.Face;
import com.au.robot.Robot;

import junit.framework.TestCase;

/**
 *  Test for the robot controller
 */
public class RobotControllerTest extends TestCase{
	
	private static final Logger LOG = Logger.getLogger(RobotControllerTest.class);
	
	RobotController controller = new RobotController();
	Robot robot = new Robot();
	
	@Before
	public void setUp(){
		LOG.info("Initial setup");
		robot.setPosition(0, 0, Face.NORTH);
	}
	
	@Test
	public void testCreateValidCommand() {
		assertEquals(Command.MOVE, controller.getCommandFromInput("MOVE"));
	}
	
	@Test
	public void testCreateInValidCommand() {
		assertNull(controller.getCommandFromInput("RUN"));
	}
	
	@Test
	public void testValidCommand() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		assertEquals(true, controller.createCommandForRobot(robot, Command.MOVE));
	}
	
	@Test
	public void testInValidCommand() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Command command = null;
		assertEquals(false, controller.createCommandForRobot(robot, command));
	}
	
	@Test
	public void testValidPlaceCommand() throws ClassCastException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		assertEquals(true, controller.createCommandForRobot(robot, "PLACE 0,0,NORTH"));
	}
	
	@Test(expected=NumberFormatException.class)
	public void testInValidPlaceCommand(){
		try {
			controller.createCommandForRobot(robot, "PLACE 1,B,NORTH");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException  e) {
			e.printStackTrace();
		}
		
	}


}
