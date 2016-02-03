package org.usfirst.frc4579.RoboEagles.commands;

import org.usfirst.frc4579.RoboEagles.Robot;
import org.usfirst.frc4579.RoboEagles.subsystems.Loader;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_Shoot extends Command {
	boolean shooting = false;
    public Cmd_Shoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.loader);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.shoot(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.shoot(.5);
    	if(Robot.measurement.getShooterSpeed() >= 500.0)  {
    		Robot.loader.set(.5);
    		if(!shooting) setTimeout(2.0);
    		shooting = true;
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (!Robot.loader.isLoaded() || isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.loader.stop();
    	Robot.shooter.shoot(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
