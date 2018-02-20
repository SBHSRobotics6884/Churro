/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6884.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	//unofficial ---> not yet set up
	public final static int LEFT_BUMP = 5; //remote button
	public final static int RIGHT_BUMP = 6; //remote button
	public final static int L_Encoder_CHANNEL_A = 6; //C--DIO--BLUE
	public final static int L_Encoder_CHANNEL_B = 7; //C--DIO--YELLOW
	public final static int R_Encoder_CHANNEL_A = 1; //C--DIO-BLUE
	public final static int R_Encoder_CHANNEL_B = 2 ; //C--DIO--YELLOW
	public final static int L_INTAKE_MOTOR = 4; //unofficial
	public final static int R_INTAKE_MOTOR = 5; //unofficial
	
	public final static int L_ELEVATOR_MOTOR = 6; //unofficial
	public final static int R_ELEVATOR_MOTOR = 7; //unofficial
	
	public final static int L1_DRIVETRAIN = 2; //C
	public final static int L2_DRIVETRAIN = 3; //C
	public final static int R1_DRIVETRAIN = 0; //C
	public final static int R2_DRIVETRAIN = 1; //C 
	public final static int SWITCH_LEFT = 5;   //C --DIO
	public final static int SWITCH_RIGHT = 0; //C --DIO
	public final static int SERVO_LEFT = 8; //unofficial
	public final static int SERVO_RIGHT = 9; //unofficial
	
	//take multiple controllers in case one goofs up
	
	
	
}
