package com.au.io;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.junit.Test;

import junit.framework.TestCase;

/** 
 * Test for the input file reader
 */
public class RobotInputFileReaderTest extends TestCase{
	
	RobotInputFileReader reader = new RobotInputFileReader();
	private Logger LOG = Logger.getLogger(RobotInputFileReaderTest.class);
	
	@Test
	public void testReadFileSuccess() throws FileNotFoundException{
		LOG.info("test success");
		assertNotNull(reader.readTestIputFile("TestInput.txt"));
	}

	@Test(expected=FileNotFoundException.class)
	public void testReadFileFail() throws FileNotFoundException{
		LOG.info("test exception");
		reader.readTestIputFile("TestInput.txt");
	}

}
