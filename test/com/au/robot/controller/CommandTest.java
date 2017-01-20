package com.au.robot.controller;

import org.junit.Test;

import com.au.robot.controller.Command;

import junit.framework.TestCase;

/**
 * Test for the command enum
 */
public class CommandTest extends TestCase{

	@Test
	public void testInvalidCommand(){
		assertNull(Command.getCommandByName("run"));
	}
	
	@Test
	public void testValidCommand(){
		assertEquals(Command.MOVE, Command.getCommandByName("move"));
	}
	
}
