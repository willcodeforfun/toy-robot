package com.au.robot;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test for the face enum
 */
public class FaceTest extends TestCase{

	@Test
	public void testInvalidCommand(){
		assertNull(Face.getFaceByName("run"));
	}
	
	@Test
	public void testValidCommand(){
		assertEquals(Face.NORTH, Face.getFaceByName("north"));
	}
	
}
