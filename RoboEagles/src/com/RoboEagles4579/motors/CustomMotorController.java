/*
 * Property of FRC TEAM 4579 - RoboEagles
 * v1.0 | 03/19/2015
 * Lead Programmer, Jaden Bottemiller
 * 
 * This class is intended to be used to estimate the speed of the motor shaft
 * given a certain input of current to the motor controller. This is not intended for
 * applications requiring specific control of speed on the motor. E.G. This does not
 * completely replace a quaderature encoder.
 * 
 * It is required that you have your Power Distribution Panel connected to the RoboRio via CAN
 * in order to be used.
 * 
 * Updates for the next release:
 * 
 * - Methods for handling variable load (currently beta)
 * 
 */

package com.RoboEagles4579.motors;

import edu.wpi.first.wpilibj.*;

public class CustomMotorController {
	
	// Set Motor Attributes
	private double maxCurrent = 0.0, 
					minCurrent = 0.0,
					maxSpeed = 0.0;
	private int pdbChannel = 0;
	// Set kConversion default value to 1.0
	private double kConversion = 1.0;
	// Set default PID parameters
	private double p = 1.0,
				   i = 0.0,
				   d = 0.0,
				   accumulatedError = 0.0, // For integration PID calculation
				   lastError = 0.0; // For dE/dt calculation
	// Set slope for Speed over Current calculation and the graph coordinate points
	private double slope = maxSpeed / (maxCurrent - minCurrent);
	private double[] topCoordinates = {maxSpeed, maxCurrent},
					bottomCoordinates = {0.0, minCurrent};
	// Sets the motor that the motor controller will control
	private SpeedController motor;
	private PowerDistributionPanel pdb;
	// Out of loop Calculations
	private double currentDifference = 0.0;
	
	/*
	 * This constructor is used to set all default parameters for the PID loop and motor
	 * 
	 * @param double maxCurrent The maximum current of the motor (stall current)
	 * @param double minCurrent The minimum current of the motor (free load current)
	 * @param double maxSpeed The free load speed of the motor (min speed is assumed to be 0.0; value in RPMs)
	 * @param SpeedController motor The motor that the motor controller is intended to control
	 * @param double p The proportional coefficient for the PID control loop
	 * @param double i The integral coefficient for the PID control loop
	 * @param double d The derivative coefficient for the PID control loop
	 * @param double kConversion Default is 1.0, this can be used to convert from RPMs into other units
	 * 
	 * kConversion is intended to be used for converting RPMs into inches per second, adjusting for wheel diameter or shaft diameter
	 * kConversion is equal to diameter of the wheel on the motor, in the units you wish to use for motor speed (such as inches for inches per second)
	 * 
	 */
	public CustomMotorController(double maxCurrent, double minCurrent, double maxSpeed, SpeedController motor, int pdbChannel, double p, double i, double d, double kConversion) {
		this.maxCurrent = maxCurrent;
		this.minCurrent = minCurrent;
		this.maxSpeed = maxSpeed;
		this.motor = motor;
		this.p = p;
		this.i = i;
		this.d = d;
		this.topCoordinates[0] = this.maxSpeed;
		this.topCoordinates[1] = this.maxCurrent;
		this.bottomCoordinates[0] = 0.0;
		this.bottomCoordinates[1] = this.minCurrent;
		if (topCoordinates[1] - topCoordinates[0] != 0) { 
			this.slope = (bottomCoordinates[0] - bottomCoordinates[1]) / (topCoordinates[1] - topCoordinates[0]);
		}
		this.pdbChannel = pdbChannel;
		this.pdb = new PowerDistributionPanel();
		currentDifference = maxCurrent-minCurrent;
	}
	/*
	 * This constructor is used to set all default parameters for the PID loop and motor
	 * 
	 * @param double maxCurrent The maximum current of the motor (stall current)
	 * @param double minCurrent The minimum current of the motor (free load current)
	 * @param double maxSpeed The free load speed of the motor (min speed is assumed to be 0.0)
	 * @param SpeedController motor The motor that the motor controller is intended to control
	 * @param double p The proportional coefficient for the PID control loop
	 * @param double i The integral coefficient for the PID control loop
	 * @param double d The derivative coefficient for the PID control loop
	 * 
	 */
	public CustomMotorController(double maxCurrent, double minCurrent, double maxSpeed, SpeedController motor, int pdbChannel, double p, double i, double d) {
		this.maxCurrent = maxCurrent;
		this.minCurrent = minCurrent;
		this.maxSpeed = maxSpeed;
		this.motor = motor;
		this.p = p;
		this.i = i;
		this.d = d;
		this.topCoordinates[0] = this.maxSpeed;
		this.topCoordinates[1] = this.maxCurrent;
		this.bottomCoordinates[0] = 0.0;
		this.bottomCoordinates[1] = this.minCurrent;
		
		if (topCoordinates[1] - topCoordinates[0] != 0) { 
			this.slope = (bottomCoordinates[0] - bottomCoordinates[1]) / (topCoordinates[1] - topCoordinates[0]);
		}
		this.pdbChannel = pdbChannel;
		this.pdb = new PowerDistributionPanel();
		currentDifference = maxCurrent-minCurrent;
	}
	/*
	 * This constructor is used to set all default parameters for the motor, and uses default PID parameters from the class
	 * 
	 * @param double maxCurrent The maximum current of the motor (stall current)
	 * @param double minCurrent The minimum current of the motor (free load current)
	 * @param double maxSpeed The free load speed of the motor (min speed is assumed to be 0.0)
	 * @param SpeedController motor The motor that the motor controller is intended to control
	 * 
	 */
	public CustomMotorController(double maxCurrent, double minCurrent, double maxSpeed, SpeedController motor) {
		this.maxCurrent = maxCurrent;
		this.minCurrent = minCurrent;
		this.maxSpeed = maxSpeed;
		this.motor = motor;
		this.topCoordinates[0] = this.maxSpeed;
		this.topCoordinates[1] = this.maxCurrent;
		this.bottomCoordinates[0] = 0.0;
		this.bottomCoordinates[1] = this.minCurrent;
		if (topCoordinates[1] - topCoordinates[0] != 0) { 
			this.slope = (bottomCoordinates[0] - bottomCoordinates[1]) / (topCoordinates[1] - topCoordinates[0]);
		}
		this.pdb = new PowerDistributionPanel();
		currentDifference = maxCurrent-minCurrent;
	}
	/*
	 * This method is intended to set the speed of the motor in inches per second (unless kConversion value adjusts for other units)
	 * 
	 * @param double speed The speed in RPMs (unless kConversion has changed units) that the motor is intended to travel at.
	 */
	public void setSpeed(double speed) {
		if (speed == 0.0) {
			motor.set(0);
		} else {
			motor.set(usePIDOutput(speed / kConversion)); // Make sure speed is in RPMs
		}
	}
	
	/*
	 * This method is intended to change the PID values currently in the class
	 * 
	 * @param double p The proportional coefficient for the PID control loop
	 * @param double i The integral coefficient for the PID control loop
	 * @param double d The derivative coefficient for the PID control loop
	 * 
	 */
	public void setPID(double p, double i, double d) {
		this.p = p;
		this.i = i;
		this.d = d;
	}
	
	
	/*
	 * Returns the PID Output from a given input (speed)
	 * 
	 * @param double speed The input from setSpeed(double speed)
	 * 
	 */
	private double usePIDOutput(double speed) {
		double I = pdb.getCurrent(pdbChannel),
			   //Adjusts for loss in speed of load
			   targetCurrent = (currentDifference*(speed)/maxSpeed)+minCurrent, 
			   error = targetCurrent - I,
			   outputCurrent = p*error + i*accumulatedError + d*(error-lastError);
		accumulatedError += error;
		lastError = error;
		double output = outputCurrent / (maxCurrent - minCurrent);
		return output;
	}
	
	/*
	 * This method overrides the pid and sets the motor to a specific value
	 * 
	 * @param double speed Relative speed [0,1] of the motor power input
	 */
	public void override(double speed) {	
		motor.set(speed);
	}
	
	/*
	 * Resets all PID accumulating variables for the PID Control loop
	 */
	public void PIDReset() {
		accumulatedError = 0.0;
		lastError = 0.0;
	}
	
	/*
	 * Hard stops the MotorController, resets the PID Values
	 */
	public void stop() {
		motor.set(0);
	}
	
	/*
	 * This method sets the conversion factor that allows the setSpeed input to be in units other than RPMs
	 * 
	 * @param double kConversion The numerical conversion factor
	 */
	public void setkConversion(double kConversion) {
		this.kConversion = kConversion;
	}
	
	/*
	 * This method returns the max current as it is set by the constructor 
	 */
	public double getMaxCurrent() {
		return maxCurrent;
	}

	/*
	 * This method returns the min current as it is set by the constructor 
	 */
	public double getMinCurrent() {
		return minCurrent;
	}
	
	/*
	 * This method returns the max speed as it is set by the constructor 
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	/*
	 * This method returns the slope of the speed over current graph as determined by the constructor
	 */
	public double getSlope() {
		return slope;
	}
	
	/*
	 * This method returns the kConversion factor
	 */
	public double getkConversion() {
		return kConversion;
	}
	
	public double getCurrent() {
		return this.pdb.getCurrent(pdbChannel);
	}
	
	/*
	 * This method returns the current motor setting [0,1]
	 */	
	public double get() {
		return motor.get();
	}

}
