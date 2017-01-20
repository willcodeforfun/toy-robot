package com.au.robot;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * This enum has the valid directions the robot can face
 */
public enum Face {
    NORTH("NORTH"),
    SOUTH("SOUTH"),
    EAST("EAST"),
    WEST("WEST");
	
	/**
	 * The map for valid face and their reference names
	 */
	private static final Map<String, Face> directionMap = new HashMap<String, Face>();
	
	private final String faceName;
	
	static { // Generate direction map
		for(Face face : EnumSet.allOf(Face.class)){
			directionMap.put(face.getFaceName().toUpperCase(), face);
		}
	}
	
	/**
	 * Constructor to create Face with valid name
	 * @param faceName
	 */
	Face(String faceName) {
		this.faceName = faceName;
	}

	public String getFaceName(){
		return this.faceName;
	}
	
	/**
	 * This method retrieves the Face by its name
	 * 
	 * @param faceName
	 * @return
	 */
	public static Face getFaceByName(String faceName) {
		return directionMap.get(faceName.toUpperCase());
	}
	
}
