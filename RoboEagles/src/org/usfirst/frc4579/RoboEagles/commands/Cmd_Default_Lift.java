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

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4579.RoboEagles.Robot;

/**
 *
 */
public class Cmd_Default_Lift extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	
	private double setpoint = 0.0,
				   lastInput = 0.0;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public Cmd_Default_Lift() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lifter);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.lifter.enable();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	update();
    	

    	
    	
    	/*if(setpoint < 0.4) {
    		setpoint = 0.4;
    	}
    	
    	if(setpoint > 4.5) {
    		setpoint = 4.5;
    	} */  		
    	
    	
    	set(setpoint);
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.lifter.disable();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private void update() {
    	setpoint = -0.941 + (0.531 * ((1. - (Robot.oi.getDriveStick().getThrottle() / 2.)) - 0.5));
    	
    	if(setpoint >= 0.47) {
    		
    		setpoint = 0.47;
    		
    	}
    }
    
    private void set(double setpoint) {
    	Robot.lifter.setSetpoint(setpoint);
    	
    
    	
    	lastInput = setpoint;
    }
    
}
