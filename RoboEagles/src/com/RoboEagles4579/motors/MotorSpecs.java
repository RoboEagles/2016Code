package com.RoboEagles4579.motors;

public class MotorSpecs {
	
	private double m_stallCurrent, //AMPS
					m_stallTorque, // OZ-IN
					m_minCurrent, //AMPS
					m_maxSpeed; //RPM
	
	public MotorSpecs(double stallCurrent, double stallTorque, double minCurrent, double maxSpeed) {
		m_stallCurrent = stallCurrent;
		m_stallTorque = stallTorque;
		m_minCurrent = minCurrent;
		m_maxSpeed = maxSpeed;
	}
	
	public double getStallCurrent() {
		return m_stallCurrent;
	}
	
	public double getStallTorque() {
		return m_stallTorque;
	}
	
	public double getMinCurrent() {
		return m_minCurrent;
	}
	
	public double getMaxSpeed() {
		return m_maxSpeed;
	}
}
