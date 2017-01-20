package com.au.robot;

import org.apache.log4j.Logger;
import org.junit.Test;
import static com.au.robot.Robot.getRobotState;

import com.au.robot.Face;
import com.au.robot.Robot;
import com.au.robot.action.Report;

import junit.framework.TestCase;

/**
 * Test for the toy-robot
 */
public class RobotTest extends TestCase {

	private Robot robot = new Robot();
	private Logger LOG = Logger.getLogger(RobotTest.class);
	
	@Test
	public void testValidState(){
		LOG.info("Check if the state is valid");
		assertEquals(true, robot.setPosition(0, 0, Face.SOUTH));
	}
	
	@Test
	public void testInvalidState(){
		LOG.info("Check if the state is not valid");
		assertEquals(false, robot.setPosition(-1, 0, Face.SOUTH));
	}

	@Test
	public void robotInitialPosition(){
		robot = new Robot();
		robot.setPosition(0, 0, Face.NORTH);
		
		LOG.info("Check the Robot is in Initial position on the board");
		assertEquals(0, getRobotState().getX());
		assertEquals(0,  getRobotState().getY());
		assertEquals(Face.NORTH, getRobotState().getFace());
		assertNull(robot.getAction());
	}
	
	
	@Test
	public void robotOnBoard(){
		robot = new Robot();
		robot.setPosition(4, 1, Face.WEST);
		robot.setAction(new Report());
		
		LOG.info("Check the Robot is placed on the board");
		assertEquals(4, getRobotState().getX());
		assertEquals(1, getRobotState().getY());
		assertEquals(Face.WEST, getRobotState().getFace());
		assertNotNull(robot.getAction());
	}
	
	@Test
	public void robotNotOnBoard(){
		robot = new Robot();
		robot.setPosition(-1, 1, Face.WEST);
		robot.setAction(new Report());
		
		LOG.info("Check the Robot is not on the board");
		assertNull(getRobotState());
		assertNotNull(robot.getAction());
	}
	
}
