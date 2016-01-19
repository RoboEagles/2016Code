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

import org.usfirst.frc4579.Lancelot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc4579.Lancelot.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton shootBtn;
    public JoystickButton loadButton;
    public Joystick driveStick;
    public JoystickButton armLiftSolenoid;
    public JoystickButton extendLiftSolenoid;
    public JoystickButton reverseDrive;
    public Joystick customControls;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        customControls = new Joystick(1);
        
        reverseDrive = new JoystickButton(customControls, 3);
        reverseDrive.whenPressed(new Cmd_ReverseDrive());
        extendLiftSolenoid = new JoystickButton(customControls, 2);
        extendLiftSolenoid.whenPressed(new Cmd_ExtendLiftSolenoid());
        armLiftSolenoid = new JoystickButton(customControls, 1);
        armLiftSolenoid.whenPressed(new Cmd_ArmLiftSolenoid());
        driveStick = new Joystick(0);
        
        loadButton = new JoystickButton(driveStick, 2);
        loadButton.whileHeld(new Cmd_Load());
        shootBtn = new JoystickButton(driveStick, 1);
        shootBtn.whenPressed(new CmdGrp_Shoot());


        // SmartDashboard Buttons
        SmartDashboard.putData("Cmd_MoveDistance: distance", new Cmd_MoveDistance(0));
        SmartDashboard.putData("AutoGrp_MoveToDefense", new AutoGrp_MoveToDefense());
        SmartDashboard.putData("Cmd_Shoot", new Cmd_Shoot());
        SmartDashboard.putData("Cmd_Load", new Cmd_Load());
        SmartDashboard.putData("CmdGrp_Shoot", new CmdGrp_Shoot());
        SmartDashboard.putData("Cmd_Default_Measure", new Cmd_Default_Measure());
        SmartDashboard.putData("Cmd_Default_Drive", new Cmd_Default_Drive());
        SmartDashboard.putData("Cmd_Default_Lift", new Cmd_Default_Lift());
        SmartDashboard.putData("Cmd_ArmLiftSolenoid", new Cmd_ArmLiftSolenoid());
        SmartDashboard.putData("Cmd_ExtendLiftSolenoid", new Cmd_ExtendLiftSolenoid());
        SmartDashboard.putData("Cmd_ReverseDrive", new Cmd_ReverseDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveStick() {
        return driveStick;
    }

    public Joystick getCustomControls() {
        return customControls;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
