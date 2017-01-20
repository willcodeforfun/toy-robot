package com.au.robot.action;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;

import com.au.robot.Face;
import com.au.robot.Robot;

import junit.framework.TestCase;

/**
 * Test to place robot on board
 */
public class PlaceTest extends TestCase {
	
	private Logger LOG = Logger.getLogger(PlaceTest.class);
	
	
	@Test
	public void testPlaceMissingX(){
		
		Action place = new Place();
		place.setY(0);
		place.setFace(Face.NORTH);
		
		Robot testRobot = new Robot();
		testRobot.setAction(place);
		LOG.info("Test X position missing");
		assertEquals(false, testRobot.getAction().execute());
	}
	
	@Test
	public void testPlaceMissingY(){
		
		Action place = new Place();
		place.setX(0);
		place.setFace(Face.NORTH);
		
		Robot testRobot = new Robot();
		testRobot.setAction(place);
		LOG.info("Test Y position missing");
		assertEquals(false, testRobot.getAction().execute());
	}
	
	@Test
	public void testPlaceDirectionMissing(){
		
		Action place = new Place();
		place.setX(0);
		place.setY(0);
		
		Robot testRobot = new Robot();
		testRobot.setAction(place);
		LOG.info("Test direction missing");
		assertEquals(false, testRobot.getAction().execute());
	}
	
	@Test
	public void testPlacedInitialPosition(){
		
		Action place = new Place();
		place.setX(0);
		place.setY(0);
		place.setFace(Face.NORTH);
		
		Robot testRobot = new Robot();
		testRobot.setAction(place);
		LOG.info("Test Place robot in Initial state");
		assertEquals(true, testRobot.getAction().execute());
	}
	
	@Test
	public void testInvalidPlace(){
		Action place = new Place();
		place.setX(-2);
		place.setY(0);
		place.setFace(Face.NORTH);
		
		Robot testRobot = new Robot();
		testRobot.setAction(place);
		LOG.info("Test Place robot in invalid state");
		assertEquals(false, testRobot.getAction().execute());
		
	}
	
	@Test
	public void testPlaceonBoard(){
		Action place = new Place();
		place.setX(4);
		place.setY(4);
		place.setFace(Face.NORTH);
		
		Robot testRobot = new Robot();
		testRobot.setAction(place);
		LOG.info("Test Place robot on board");
		assertEquals(true, testRobot.getAction().execute());
		
	}
	
	@After
	public void tearDown(){
		Robot.setRobotState(null);
	}

}
