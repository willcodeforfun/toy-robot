package com.au.robot.action;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;

import com.au.robot.Face;
import com.au.robot.Robot;

import junit.framework.TestCase;

/**
 * test to turn robot left
 */
public class LeftTest extends TestCase{
	
	private Logger LOG = Logger.getLogger(LeftTest.class);
	
	@Test
	public void testTurnLeftFailed(){
		Robot testRobot = new Robot();
		testRobot.setPosition(-1, 1, Face.SOUTH);
		testRobot.setAction(new Left());
		LOG.info("Test Left action failed");
		assertEquals(false, testRobot.getAction().execute());
	}
	
	@Test
	public void testSuccessfulLeft(){
		Robot testRobot = new Robot();
		testRobot.setPosition(3, 1, Face.EAST);
		testRobot.setAction(new Left());
		LOG.info("Test Left action success");
		assertEquals(true, testRobot.getAction().execute());
		
	}
	
	@After
	public void tearDown(){
		Robot.setRobotState(null);
	}

}
