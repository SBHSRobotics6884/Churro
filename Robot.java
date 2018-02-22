/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6884.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6884.robot.commands.Drive;
import org.usfirst.frc.team6884.robot.commands.ElevatorDown;
import org.usfirst.frc.team6884.robot.commands.ElevatorUp;
import org.usfirst.frc.team6884.robot.commands.Intake;
import org.usfirst.frc.team6884.robot.commands.ReverseIntake;
import org.usfirst.frc.team6884.robot.subsystems.DriveSystem;

import org.usfirst.frc.team6884.robot.subsystems.ElevatorSystem;
import org.usfirst.frc.team6884.robot.subsystems.EncoderSystem;
import org.usfirst.frc.team6884.robot.subsystems.IntakeSystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static DriveSystem drive;
	public static OI m_oi;
	public static RobotMap map;
	public static EncoderSystem encoder;
	public static ElevatorSystem elevator;
	public static IntakeSystem intake;
	
	Command cDrive;
	ElevatorUp cElevatorUp;
	ElevatorDown cElevatorDown;
	//Intake cIntake;
	//ReverseIntake cReverseIntake;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		drive = new DriveSystem();
		cDrive = new Drive();
		map = new RobotMap();
		encoder = new EncoderSystem();
		elevator = new ElevatorSystem();
		//cElevatorDown = new ElevatorDown();
		//cElevatorUp = new ElevatorUp();
		//cIntake = new Intake();
		//cReverseIntake = new ReverseIntake();
		intake = new IntakeSystem();
		
		//m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
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
		Scheduler.getInstance().run();
		
		
		//if (encoder.getD1() >= 4 )
	//		drive.drive(-.3,0);
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
		
		//cElevatorUp.start();
		//cElevatorDown.start();
		//cIntake.start();
		//cReverseIntake.start();
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		cDrive.start();
		//cElevatorUp.start();
		//cElevatorDown.start();
		//cIntake.start();
		//cReverseIntake.start();
		
		elevator.getML();
		elevator.getMR();
		
		/*
			cDrive.start();
		SmartDashboard.putNumber("Encoder Distance", encoder.getD1());
		SmartDashboard.putNumber("Encoder Rate", encoder.getD2());
		
		System.out.print(encoder.testA());
		System.out.print(encoder.
		testB());
		*/
		
		
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
	public static DriveSystem getDrive() {
		return drive;
	}
	public static ElevatorSystem getElevator() {
		return elevator;
	}
	public static IntakeSystem getIntake() {
		return intake;
	}
}
