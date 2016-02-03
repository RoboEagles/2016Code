// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.RoboEagles;

import com.RoboEagles4579.motors.MotorSpecs;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static Accelerometer robotAccelerometer;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainleftMotor;
    public static SpeedController drivetrainrightMotor;
    public static RobotDrive drivetrainrobotDrive;
    public static SpeedController loaderloadMotor;
    public static DigitalInput loaderloadLimit;
    public static SpeedController shootershootMotor;
    public static AnalogGyro measurementrobotGyro;
    public static PowerDistributionPanel measurementrobotPDB;
    public static Ultrasonic measurementrobotUltrasonic;
    public static AnalogPotentiometer lifterlifterPotentiometer;
    public static SpeedController lifterlifterMotor;
    public static DoubleSolenoid lifterlifterArmExtension;
    public static DigitalInput liftertopLimit;
    public static DigitalInput lifterbottomLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static MotorSpecs miniCIM = new MotorSpecs(86., 198.4, 1.5, 6200.0);
    public static MotorSpecs CIM = new MotorSpecs(133.0, 343.4, 2.7, 5310.0);
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainleftMotor = new Talon(0);
        LiveWindow.addActuator("Drivetrain", "leftMotor", (Talon) drivetrainleftMotor);
        
        drivetrainrightMotor = new Talon(1);
        LiveWindow.addActuator("Drivetrain", "rightMotor", (Talon) drivetrainrightMotor);
        
        drivetrainrobotDrive = new RobotDrive(drivetrainleftMotor, drivetrainrightMotor);
        
        drivetrainrobotDrive.setSafetyEnabled(true);
        drivetrainrobotDrive.setExpiration(0.1);
        drivetrainrobotDrive.setSensitivity(0.5);
        drivetrainrobotDrive.setMaxOutput(1.0);

        drivetrainrobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        loaderloadMotor = new Talon(2);
        LiveWindow.addActuator("Loader", "loadMotor", (Talon) loaderloadMotor);
        
        loaderloadLimit = new DigitalInput(0);
        LiveWindow.addSensor("Loader", "loadLimit", loaderloadLimit);
        
        shootershootMotor = new Talon(3);
        LiveWindow.addActuator("Shooter", "shootMotor", (Talon) shootershootMotor);
        
        measurementrobotGyro = new AnalogGyro(0);
        LiveWindow.addSensor("Measurement", "robotGyro", measurementrobotGyro);
        measurementrobotGyro.setSensitivity(0.007);
        measurementrobotPDB = new PowerDistributionPanel(0);
        LiveWindow.addSensor("Measurement", "robotPDB", measurementrobotPDB);
        
        measurementrobotUltrasonic = new Ultrasonic(1, 2);
        LiveWindow.addSensor("Measurement", "robotUltrasonic", measurementrobotUltrasonic);
        
        lifterlifterPotentiometer = new AnalogPotentiometer(1, 260.0, 0.0);
        LiveWindow.addSensor("Lifter", "lifterPotentiometer", lifterlifterPotentiometer);
        
        lifterlifterMotor = new Talon(4);
        LiveWindow.addActuator("Lifter", "lifterMotor", (Talon) lifterlifterMotor);
        
        lifterlifterArmExtension = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Lifter", "lifterArmExtension", lifterlifterArmExtension);
        
        liftertopLimit = new DigitalInput(3);
        LiveWindow.addSensor("Lifter", "topLimit", liftertopLimit);
        
        lifterbottomLimit = new DigitalInput(4);
        LiveWindow.addSensor("Lifter", "bottomLimit", lifterbottomLimit);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        robotAccelerometer = new BuiltInAccelerometer(Accelerometer.Range.k2G);
    }
}
