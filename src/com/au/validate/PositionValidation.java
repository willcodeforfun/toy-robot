package com.au.validate;

import org.apache.log4j.Logger;

/**
 * This class validates the position of the Robot
 * Valid position is between 0 to 4 for X, 0 to 4 for Y
 */
public class PositionValidation {

	private Logger LOG = Logger.getLogger(PositionValidation.class);
	
	/**
	 * This method validates the X and Y positions
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean validatePosition(int x, int y) {
		return (checkPosition(x, "X") && checkPosition(y, "Y"));
	}

	/**
	 * This method checks if the position is within boundaries
	 * 
	 * @param value
	 * @param position
	 * @return
	 */
	private boolean checkPosition(int value, String position) {
		boolean isValid = true;
		if (!checkBoundary(value)) {
			isValid = false;
			LOG.error("Invalid " + position + " position : " + value);
		}
		return isValid;
	}

	/**
	 * This method checks if the position follows both boundaries
	 * 
	 * @param position
	 * @return
	 */
	private boolean checkBoundary(int position) {
		return (checkMinumumBoundary(position) && checkMaximumBoundary(position)) ? true : false;
	}

	/**
	 * This method check the minimum boundary for the position
	 * 
	 * @param position
	 * @return
	 */
	private boolean checkMinumumBoundary(int position) {
		return (position >= 0) ? true : false;
	}

	/**
	 * This method checks the maximum boundary for the position
	 * 
	 * @param position
	 * @return
	 */
	private boolean checkMaximumBoundary(int position) {
		return (position <= 4) ? true : false;
	}

}
