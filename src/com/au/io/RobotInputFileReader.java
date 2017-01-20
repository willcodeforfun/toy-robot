package com.au.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

import org.apache.log4j.Logger;

import com.au.play.RobotSimulator;

/**
 * This class reads the input file containing the test cases
 */
public class RobotInputFileReader {

	private Logger LOG = Logger.getLogger(RobotInputFileReader.class);
	
	/**
	 * This method reads the file and return the buffered reader for the file
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public BufferedReader readTestIputFile(String fileName) throws FileNotFoundException {
		URL url = RobotSimulator.class.getResource(fileName);
		FileReader reader = new FileReader(url.getPath());
		LOG.info("Input file is : " + fileName);
		return new BufferedReader(reader);
	}

}
