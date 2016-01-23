// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.RoboEagles.subsystems;

import org.usfirst.frc4579.RoboEagles.RobotMap;
import org.usfirst.frc4579.RoboEagles.commands.*;

import com.RoboEagles4579.filters.SecondOrderLPF;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drivetrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController leftMotor = RobotMap.drivetrainleftMotor;
    private final SpeedController rightMotor = RobotMap.drivetrainrightMotor;
    private final RobotDrive robotDrive = RobotMap.drivetrainrobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private boolean invertedDrive = false;
    
    private SecondOrderLPF xLPF = new SecondOrderLPF();
    private SecondOrderLPF yLPF = new SecondOrderLPF();
    
    public void drive(double x, double y) {
    	
    	x = xLPF.filter(x);
    	y = yLPF.filter(y);
    	
    	x *= x;
    	y *= y;
    	
    	x = invertedDrive ? -x : x;
    	y = invertedDrive ? -y : y;
    	
    	
    	robotDrive.arcadeDrive(x, y);
    	
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Cmd_Default_Drive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
