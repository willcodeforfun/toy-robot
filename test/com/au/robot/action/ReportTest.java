package com.au.robot.action;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;

import com.au.robot.Face;
import com.au.robot.Robot;
import com.au.robot.action.Report;

import junit.framework.TestCase;

/**
 * Test to report the state of the robot
 */
public class ReportTest extends TestCase{
	
	private Logger LOG = Logger.getLogger(ReportTest.class);
	
	@Test
	public void testReportFailed(){
		Robot testRobot = new Robot();
		testRobot.setPosition(-1, 1, Face.SOUTH);
		testRobot.setAction(new Report());
		LOG.info("Test Report action failed");
		assertEquals(false, testRobot.getAction().execute());
	}
	
	@Test
	public void testSuccessfulReport(){
		Robot testRobot = new Robot();
		testRobot.setPosition(3, 1, Face.EAST);
		testRobot.setAction(new Report());
		LOG.info("Test Report action success");
		assertEquals(true, testRobot.getAction().execute());
		
	}
	
	@After
	public void tearDown(){
		Robot.setRobotState(null);
	}

}
