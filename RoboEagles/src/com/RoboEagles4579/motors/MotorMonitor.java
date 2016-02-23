package com.RoboEagles4579.motors;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class MotorMonitor {
	
	private int motorPDBChannel = 0;
	private PowerDistributionPanel robotPDB;
	private MotorSpecs motor;
	
	public MotorMonitor(int motorPDBChannel, MotorSpecs motor) {
		this.robotPDB = new PowerDistributionPanel();
		this.motorPDBChannel = motorPDBChannel;
		this.motor = motor;
	}
	
	
	private double getCurrent() {
		return this.robotPDB.getCurrent(motorPDBChannel);
	}
	
	public double getSpeed() {
		
		double maxSpeed = motor.getMaxSpeed();
		double stallCurrent = motor.getStallCurrent();
		double minCurrent = motor.getMinCurrent();
		double current = getCurrent();
				
		return -1*(maxSpeed / (stallCurrent - minCurrent)) * current + ((maxSpeed) / (stallCurrent - minCurrent) * minCurrent); 
		
	}
	

}
