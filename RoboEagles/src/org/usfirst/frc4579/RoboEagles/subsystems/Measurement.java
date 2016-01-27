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

import org.usfirst.frc4579.RoboEagles.Robot;
import org.usfirst.frc4579.RoboEagles.RobotMap;
import org.usfirst.frc4579.RoboEagles.commands.*;

import com.RoboEagles4579.motors.MotorMonitor;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Ultrasonic;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Measurement extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AnalogGyro robotGyro = RobotMap.measurementrobotGyro;
    private final PowerDistributionPanel robotPDB = RobotMap.measurementrobotPDB;
    private final Ultrasonic robotUltrasonic = RobotMap.measurementrobotUltrasonic;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final MotorMonitor loaderMotorMonitor = new MotorMonitor(13);
    private double loaderMotorCurrent;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Cmd_Default_Measure());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void measure() {
    	
    	loaderMotorCurrent = loaderMotorMonitor.getCurrent();
    	
    }
    
    public double getLoaderCurrent() {
    	return loaderMotorCurrent;
    }
    
}

