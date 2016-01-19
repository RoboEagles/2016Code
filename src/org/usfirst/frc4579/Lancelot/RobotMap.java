// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.Lancelot;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainleftMotor;
    public static SpeedController drivetrainrightMotor;
    public static RobotDrive drivetrainrobotDrive;
    public static AnalogGyro measurementrobotGyro;
    public static Ultrasonic measurementrobotUltrasonic;
    public static PowerDistributionPanel measurementrobotPDB;
    public static SpeedController loaderloaderMotor;
    public static DigitalInput loaderloaderLimit;
    public static Encoder shootshootEncoder;
    public static SpeedController shootshootMotor;
    public static Encoder lifterlifterEncoder;
    public static SpeedController lifterliftMotor;
    public static DoubleSolenoid lifterliftSolenoid;
	public static AnalogPotentiometer lifterliftPotentiometer;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

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
        drivetrainrobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        measurementrobotGyro = new AnalogGyro(0);
        LiveWindow.addSensor("Measurement", "robotGyro", measurementrobotGyro);
        measurementrobotGyro.setSensitivity(0.007);
        measurementrobotUltrasonic = new Ultrasonic(0, 1);
        LiveWindow.addSensor("Measurement", "robotUltrasonic", measurementrobotUltrasonic);
        
        measurementrobotPDB = new PowerDistributionPanel(0);
        LiveWindow.addSensor("Measurement", "robotPDB", measurementrobotPDB);
        
        loaderloaderMotor = new Talon(2);
        LiveWindow.addActuator("Loader", "loaderMotor", (Talon) loaderloaderMotor);
        
        loaderloaderLimit = new DigitalInput(2);
        LiveWindow.addSensor("Loader", "loaderLimit", loaderloaderLimit);
        
        shootshootEncoder = new Encoder(3, 4, false, EncodingType.k4X);
        LiveWindow.addSensor("Shoot", "shootEncoder", shootshootEncoder);
        shootshootEncoder.setDistancePerPulse(1.0);
        shootshootEncoder.setPIDSourceType(PIDSourceType.kRate);
        shootshootMotor = new Talon(3);
        LiveWindow.addActuator("Shoot", "shootMotor", (Talon) shootshootMotor);
        
        lifterlifterEncoder = new Encoder(5, 6, false, EncodingType.k4X);
        LiveWindow.addSensor("Lifter", "lifterEncoder", lifterlifterEncoder);
        lifterlifterEncoder.setDistancePerPulse(1.0);
        lifterlifterEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        lifterliftMotor = new Talon(4);
        LiveWindow.addActuator("Lifter", "liftMotor", (Talon) lifterliftMotor);
        
        lifterliftSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Lifter", "liftSolenoid", lifterliftSolenoid);
        
        lifterliftPotentiometer = new AnalogPotentiometer(1);
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
    }
}
