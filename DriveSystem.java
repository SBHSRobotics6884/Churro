package org.usfirst.frc.team6884.robot.subsystems;

import org.usfirst.frc.team6884.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSystem extends Subsystem {

	public Spark l1;
	public Spark r1;
	
	
	public Spark l2;
	public Spark r2;
	
	public SpeedControllerGroup m_right;
	public SpeedControllerGroup m_left;
	
	public DifferentialDrive m_drive;   
	
	
		
		
	public DriveSystem() {
		
		l1 = new Spark(RobotMap.L1_DRIVETRAIN);
		l2 = new Spark(RobotMap.L2_DRIVETRAIN);
		m_left = new SpeedControllerGroup(l1,l2);
		
	
		r1 = new Spark(RobotMap.R1_DRIVETRAIN);
		r1 = new Spark(RobotMap.R2_DRIVETRAIN);

		m_right = new SpeedControllerGroup(r1,r2);
		
		m_drive = new DifferentialDrive(m_left, m_right);
	}
	

	public void drive(double speed, double rotation) {
		
		m_drive.arcadeDrive(speed,rotation);
		
	}
	public void reduceSpeed() {
		drive(.3,0);
	}
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		
	}
	
	

}
