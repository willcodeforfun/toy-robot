package com.au.robot.action;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;

import com.au.robot.Face;
import com.au.robot.Robot;

import junit.framework.TestCase;

/**
 * Test to turn robot right
 */
public class RightTest extends TestCase {
	
	private Logger LOG = Logger.getLogger(RightTest.class);
	
	@Test
	public void testTurnRightFailed(){
		Robot testRobot = new Robot();
		testRobot.setPosition(-1, 1, Face.SOUTH);
		testRobot.setAction(new Right());
		LOG.info("Test Right action failed");
		assertEquals(false, testRobot.getAction().execute());
	}
	
	@Test
	public void testSuccessfulRight(){
		Robot testRobot = new Robot();
		testRobot.setPosition(3, 1, Face.EAST);
		testRobot.setAction(new Right());
		LOG.info("Test Right action right");
		assertEquals(true, testRobot.getAction().execute());
	}
	
	@After
	public void tearDown(){
		Robot.setRobotState(null);
	}

}
