package com.au.robot.action;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;

import com.au.robot.Face;
import com.au.robot.Robot;

import junit.framework.TestCase;

/**
 * Test to move robot by one unit
 */
public class MoveTest extends TestCase{
	
	private Logger LOG = Logger.getLogger(PlaceTest.class);
	
	@Test
	public void testMoveEast(){
		Robot testRobot = new Robot();
		testRobot.setPosition(0, 0, Face.EAST);
		testRobot.setAction(new Move());
		LOG.info("Test Move east ");
		assertEquals(true, testRobot.getAction().execute());
	}
	
	@Test
	public void testMoveEastInvalid(){
		Robot testRobot = new Robot();
		testRobot.setPosition(4, 0, Face.EAST);
		testRobot.setAction(new Move());
		LOG.info("Test Move east Invalid");
		assertEquals(false, testRobot.getAction().execute());
	}
	
	@Test
	public void testMoveWest(){
		Robot testRobot = new Robot();
		testRobot.setPosition(4, 1, Face.WEST);
		testRobot.setAction(new Move());
		LOG.info("Test Move west ");
		assertEquals(true, testRobot.getAction().execute());
	}
	
	@Test
	public void testMoveWestInvalid(){
		Robot testRobot = new Robot();
		testRobot.setPosition(0, 0, Face.WEST);
		testRobot.setAction(new Move());
		LOG.info("Test Move West Invalid");
		assertEquals(false, testRobot.getAction().execute());
	}
	
	@Test
	public void testMoveNorth(){
		Robot testRobot = new Robot();
		testRobot.setPosition(0, 1, Face.NORTH);
		testRobot.setAction(new Move());
		LOG.info("Test Move north ");
		assertEquals(true, testRobot.getAction().execute());
	}
	
	@Test
	public void testMoveNorthInvalid(){
		Robot testRobot = new Robot();
		testRobot.setPosition(4, 4, Face.NORTH);
		testRobot.setAction(new Move());
		LOG.info("Test Move north Invalid");
		assertEquals(false, testRobot.getAction().execute());
	}
	
	
	@Test
	public void testMoveSouth(){
		Robot testRobot = new Robot();
		testRobot.setPosition(0, 1, Face.SOUTH);
		testRobot.setAction(new Move());
		LOG.info("Test Move south ");
		assertEquals(true, testRobot.getAction().execute());
	}
	
	@Test
	public void testMoveSouthInvalid(){
		Robot testRobot = new Robot();
		testRobot.setPosition(0, 0, Face.SOUTH);
		testRobot.setAction(new Move());
		LOG.info("Test Move south Invalid");
		assertEquals(false, testRobot.getAction().execute());
	}
	
	
	@After
	public void tearDown(){
		Robot.setRobotState(null);
	}

}
