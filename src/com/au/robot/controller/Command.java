
package com.au.robot.controller;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * This enum contains the list of commands the Robot can follow
 *
 */
public enum Command {
	
	PLACE("Place"),
	MOVE("Move"),
	LEFT("Left"),
	RIGHT("Right"),
	REPORT("Report");
	
	/**
	 * This is a map of the commands and their valid names
	 */
	private static final Map<String, Command> commandMap = new HashMap<String, Command>();
	private final String commandName;
	
	static { // Generate the command map
		for(Command command : EnumSet.allOf(Command.class)){
			commandMap.put(command.getCommandName().toLowerCase(), command);
		}
	}
	
	Command(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandName(){
		return this.commandName;
	}
	
	/**
	 * This method gets the command by name
	 * 
	 * @param commandName
	 * @return
	 */
	public static Command getCommandByName(String commandName) {
		return commandMap.get(commandName.toLowerCase());
	}
	
}
