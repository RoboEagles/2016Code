// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.RoboEagles.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc4579.RoboEagles.Robot;
import org.usfirst.frc4579.RoboEagles.RobotMap;

/**
 *
 */
public class Cmd_MoveDistance extends PIDCommand {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_distance, m_startDistance, m_targetDistance;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public Cmd_MoveDistance(double distance) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("Cmd_MoveDistance", 1.0, 0.0, 0.0, 0.02);
        getPIDController().setContinuous(false);
        getPIDController().setAbsoluteTolerance(0.2);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_distance = distance;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	
    	/*
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return RobotMap.measurementrobotUltrasonic.pidGet();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
         * 
         */
    	
    	return Robot.measurement.getDistances().X / 12; //returns feet
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        RobotMap.drivetrainleftMotor.pidWrite(output);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        RobotMap.drivetrainrightMotor.pidWrite(output);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	//m_startDistance = Robot.measurement.getFieldPosition().X;
    	m_targetDistance = m_startDistance + m_distance;
    	
    	setSetpoint(m_targetDistance);
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	usePIDOutput(0.);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
