/*
 * Property of FRC TEAM 4579 - RoboEagles
 * v1.0 | 03/19/2015
 * Lead Programmer, Jaden Bottemiller
 * 
 * This class is intended to be used as a first order low pass filter for inputs to another system.
 * For example: a joystick input to a motor controller
 * 
 * The output of the filter() method is what needs to be fed into the other system
 * E.G. motor.filter(1);
 * 
 */
package com.RoboEagles4579.filters;

public class FirstOrderLPF {
	
	private double lpfk = 0.25, // Low pass filter time constant [Greater the number, higher rate of change (typically means higher sensitivity)]
				   lastValue = 0.0; // Last stored value (Default: 0)
	
	/*
	 * 
	 * @param double kFilter Time constant for the low pass filter. Domain: [0,1] [Greater the number, higher rate of change (typically means higher sensitivity)]
	 */
	public FirstOrderLPF(double kFilter) {
		lpfk = kFilter;
		reset();
	}
	/*
	 * Defaults the time constant of the low pass filter to 0.25
	 */
	public FirstOrderLPF() {
		reset();
	}
	/* Main filter method for the low pass filter mechanism.
	 * Input a value, Output the filtered value (this will filter based on the last stored value)
	 * @param double input The input to filter.
	 */
	public double filter(double input) {
		double output = lastValue + lpfk * (input - lastValue);
		lastValue = output;
		return output;
	}
	
	/*
	 * This method hard sets the time constant for the low pass filter 
	 * @param double kFilter Time constant for the low pass filter. Domain: [0,1] [Greater the number, higher rate of change (typically means higher sensitivity)]
	 */
	public void setKFilter(double kFilter) {
		lpfk = kFilter;
	}
	
	/*
	 * This method returns the current time constant for the low pass filter.
	 */
	public double getLPFK() {
		return lpfk;
	}
	
	/*
	 * Hard resets the last stored value to zero
	 */
	public void reset() {
		lastValue = 0.;
	}

}
