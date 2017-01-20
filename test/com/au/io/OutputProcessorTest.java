package com.au.io;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.au.robot.Robot;
import com.au.robot.RobotTest;
import com.au.robot.state.RobotState;

import junit.framework.TestCase;

/**
 * Test for the output processor
 *
 */
public class OutputProcessorTest extends TestCase {
	
	private OutputProcessor output = new OutputProcessor();
	private Logger LOG = Logger.getLogger(RobotTest.class);
	
	@Test
	public void testdisplaySuccess(){
		Robot.setRobotState(new RobotState());
		LOG.info("Test success display");
		assertEquals(true, output.displayOutput());
	}

	
	@Test
	public void testdisplayFail(){
		Robot.setRobotState(null);
		LOG.info("Test fail display");
		assertEquals(false, output.displayOutput());
	}

}
