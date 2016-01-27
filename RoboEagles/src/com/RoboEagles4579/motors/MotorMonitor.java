package com.RoboEagles4579.motors;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class MotorMonitor {
	
	private int motorPDBChannel = 0;
	private PowerDistributionPanel robotPDB;
	private MotorSpecs motor;
	
	public MotorMonitor(int motorPDBChannel, MotorSpecs motor) {
		this.robotPDB = new PowerDistributionPanel();
		this.motorPDBChannel = motorPDBChannel;
	}
	
	
	private double getCurrent() {
		return this.robotPDB.getCurrent(motorPDBChannel);
	}
	
	public double getSpeed() {
		
		double speed = -1*(motor.getMaxSpeed()*(this.getCurrent()-motor.getMinCurrent()))
						/(motor.getStallCurrent()-motor.getMinCurrent()) + motor.getMaxSpeed();
		
		return speed;
	}
	

}
