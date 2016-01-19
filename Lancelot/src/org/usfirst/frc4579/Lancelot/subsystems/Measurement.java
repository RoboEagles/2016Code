// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.Lancelot.subsystems;

import org.usfirst.frc4579.Lancelot.RobotMap;
import org.usfirst.frc4579.Lancelot.commands.*;

import com.RoboEagles4579.math.Vector2d;
import com.RoboEagles4579.math.Vector3d;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Ultrasonic;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;


/**
 *
 */
public class Measurement extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AnalogGyro robotGyro = RobotMap.measurementrobotGyro;
    private final Ultrasonic robotUltrasonic = RobotMap.measurementrobotUltrasonic;
    private final PowerDistributionPanel robotPDB = RobotMap.measurementrobotPDB;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Accelerometer robotAccelerometer = new BuiltInAccelerometer();

    

    //Values we have to measure
    
    
    private double gyroAngle,
    				gyroRate,
    				ultrasonicDistance,
    				loaderCurrent,
    				shootCurrent;
    private Vector3d trajectory;
    private Vector2d relativeFieldCoordinates;
    private Vector3d directionalSpeed;
    private Vector3d directionalAcceleration;
    
    
    
    //Constructor (is called when object is created)
    
    public Measurement() {
    	
    	initialize();
    	
    }
    
    public void initialize() {
    	
    	robotGyro.initGyro();
    	
    }
    
    public void measure() {
    	
    }
    
    public double getDistanceSensor() {
		return 0;
    }
    
    public Vector2d getDistance() {
		return null;
    }
    
    public Vector3d getTrajectory() {
		return null;
    }
    
    public double getAngle() {
		return 0;
    }

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Cmd_Default_Measure());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

