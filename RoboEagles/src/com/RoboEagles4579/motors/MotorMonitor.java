package com.RoboEagles4579.motors;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class MotorMonitor {
	
	private int motorPDBChannel = 0;
	private PowerDistributionPanel robotPDB;
	
	
	public MotorMonitor(int motorPDBChannel) {
		this.robotPDB = new PowerDistributionPanel();
		this.motorPDBChannel = motorPDBChannel;
	}
	
	public double getCurrent() {
		return this.robotPDB.getCurrent(motorPDBChannel);
	}

}
