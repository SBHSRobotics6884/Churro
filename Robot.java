/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6884.robot;

import org.usfirst.frc.team6884.robot.commands.Drive;
import org.usfirst.frc.team6884.robot.subsystems.DriveSystem;
import org.usfirst.frc.team6884.robot.subsystems.EncoderSystem;
import org.usfirst.frc.team6884.robot.subsystems.GyroSystem;
import org.usfirst.frc.team6884.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	//Create Subystems Here
	public static IntakeSystem intake;
	public static DriveSystem drive;
	public static GyroSystem gyro;
	public static EncoderSystem encoder;
	
	
	//public static ElevatorSystem elevator;
			
	Command cDrive;
	public static OI m_oi;
	
	
	DigitalInput switchLeft;
	DigitalInput switchRight;
	int state;
	double encoderDistance;
	

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//Init Subystems Here
		intake = new IntakeSystem();
		drive = new DriveSystem();
		gyro = new GyroSystem();
		encoder = new EncoderSystem();
	
		//elevator = new ElevatorSystem();
		
		m_oi = new OI();
		switchLeft = new DigitalInput(RobotMap.SWITCH_LEFT);
		switchRight = new DigitalInput(RobotMap.SWITCH_RIGHT);
		
		//m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		OI.init();
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		
		state = 1;
		String switchPos;
		
		switchPos = DriverStation.getInstance().getGameSpecificMessage();
		//then use charAt(index) method to check which is ours, returns 'L' or 'R'

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		//second test
		Scheduler.getInstance().run();
		drive.drive(.3, 0);
		gyro.driveStraight();
		encoderDistance = encoder.distance();
		System.out.print(encoder.distance());
		//end second test
		/*if(state == 1)
			if(encoder.Distance() <= 15) {
				drive.drive(.4,0);
				gyro.driveStraight();
			}
			else {
				state = 2;
				encoder.reset();
			}
		//the system updates periodically (state variable still keeps value since it is in autoINIT)
		//assuming left1 is ours and we start on left 
		else if(state == 2) {
			gyro.turn90Clockwise();
			state = 3;
			encoder.reset();
		}
		else if(state == 3) 
			if(encoder.distance() <= 2) {
				drive.drive(.2,0);
				gyro.driveStraight();
			}
			else {
				state = 4;
				encoder.reset();
			}
		else if(state == 4) {
			intake.reverseIntake();
			state = 5;
			encoder.reset();
		}
		//going backwards that short distance
		else if(state == 5)
			if(encoder.distance() <= 2) {
				drive.drive(-.2,0); // go backwards
				gyro.driveStraight();
			}
			else {
				state = 6;
				encoder.reset();
			}
		//turning counter clockwise from being backwards
		else if(state == 6) {
			gyro.turn90CounterClockwise();
			state = 7; 
			encoder.reset();
		}
		else if(state == 7)
			if(encoder.distance() <= 27.125) //not completely sure about this d
				drive.reduceSpeed();
			else {
				state = 8;
				encoder.reset();
			}
		
			*/ 	
			
	
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		cDrive = new Drive();
		//This is to test the encoders
		
		
		
		
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//test one
		cDrive.start(); //this is the arcadeDrive
		System.out.println(encoder.distance());
		//test one ends
		
		//test three
		/*
		if(switchLeft.get() && !switchRight.get())
			System.out.print("LEFT SWITCH");
		else if(!switchLeft.get() && switchRight.get())
			System.out.print("RIGHT SWITCH");
		else if(!switchLeft.get() && !switchRight.get())
			System.out.print("CENTER SWITCH");
		else
			System.out.print("error"); 
		*/
		//test three ends
		
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		
	}
	
	
	
	//Create Getters Here for Commands
	
	public static DriveSystem getDrive() {
		return drive; 
	}
	
	public static IntakeSystem getIntake() {
		
		return intake;
	}
	
	//public static ElevatorSystem() {
	//	return elevator;
	//}
	
	
	
	
}
