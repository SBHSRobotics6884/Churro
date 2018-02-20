package org.usfirst.frc.team6884.robot.subsystems;

import org.usfirst.frc.team6884.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSystem extends Subsystem {

	public Spark leftIntake;
	public Spark rightIntake;

	
	public IntakeSystem() {
		leftIntake = new Spark(RobotMap.L_INTAKE_MOTOR);
		rightIntake = new Spark(RobotMap.R_INTAKE_MOTOR);
	
	}
	
	public void intake() {
		leftIntake.setSpeed(.2);
		rightIntake.setSpeed(-.2);
	}
	public void reverseIntake() {
		leftIntake.setSpeed(-.2);
		rightIntake.setSpeed(-.2);
	
	}
	
	public void stopIntake() {
		leftIntake.setSpeed(0);
		rightIntake.setSpeed(0);
	
	}

	//for some reaon you need this
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	} 
}
