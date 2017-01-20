package com.au.validate;

import org.apache.log4j.Logger;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test for the position validator
 */
public class PositionValidationTest extends TestCase {

	
	private PositionValidation validator = new PositionValidation();
	private Logger LOG = Logger.getLogger(PositionValidationTest.class);
	
	
	@Test
	public void testMinimumRowBoundry(){
		LOG.info("Test to check miniumum row boundary");
		assertEquals(false, validator.validatePosition(-1, 0));
	}
	
	@Test
	public void testMaximumRowBoundry(){
		LOG.info("Test to check maximum row boundary");
		assertEquals(false, validator.validatePosition(5, 0));
	}
	
	@Test
	public void testMinimumColumnBoundry(){
		LOG.info("Test to check minimum column boundary");
		assertEquals(false, validator.validatePosition(0, -1));
	}
	
	@Test
	public void testMaximumColumnBoundry(){
		LOG.info("Test to check maximum column boundary");
		assertEquals(false, validator.validatePosition(0, 5));
	}
	
	@Test
	public void testBothInvalidPositions(){
		LOG.info("Test to check invalid position");
		assertEquals(false, validator.validatePosition(5, 5));
	}
	
	@Test
	public void testValidPosition(){
		LOG.info("Test to check valid position is set");
		assertEquals(true, validator.validatePosition(2, 4));
	}
}
