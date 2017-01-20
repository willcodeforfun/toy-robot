package com.au.robot.controller;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.au.robot.Face;
import com.au.robot.Robot;

import junit.framework.TestCase;

/**
 * Test for the action generator
 */
public class ActionGeneratorTest extends TestCase{
	
	private Logger LOG = Logger.getLogger(ActionGeneratorTest.class);
	
	ActionGenerator controller = new ActionGenerator();
	Robot robot = new Robot();
	
	@Before
	public void setUp(){
		LOG.info("Initial setup");
		robot.setPosition(0, 0, Face.SOUTH);
	}
	
	@Test
	public void testValidCommand() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		assertEquals(true, controller.performAction(robot, Command.REPORT));
	}
	
	@Test
	public void testInValidCommand() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		assertEquals(false, controller.performAction(robot, null));
	}
	
	@Test
	public void testShouldNotThrowClassCastException() throws ClassCastException{
		try {
			controller.performAction(robot, Command.REPORT);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testShouldNotThrowInstantiationException() throws InstantiationException{
		try {
			controller.performAction(robot, Command.REPORT);
		} catch (IllegalAccessException | ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}
	
	@Test
	public void testShouldNotThrowIllegalAccessException() throws IllegalAccessException{
		try {
			controller.performAction(robot, Command.REPORT);
		} catch (InstantiationException | ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}


}
