package org.usfirst.frc.team6884.robot.subsystems;

import org.usfirst.frc.team6884.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class EncoderSystem extends Subsystem{
	Encoder encoderLeft; 
	Encoder encoderRight;
	
	
	double radiusOfWheel = 3;
	double circumOfWheel = 2 * Math.PI * radiusOfWheel;
	
	double encoderDistance;
	double distancePerPulse = circumOfWheel/12 /1440;
	
	public EncoderSystem() {
		encoderLeft = new Encoder( RobotMap.L_Encoder_CHANNEL_A , RobotMap.L_Encoder_CHANNEL_B );
		encoderRight = new Encoder(RobotMap.R_Encoder_CHANNEL_A, RobotMap.R_Encoder_CHANNEL_B);
		encoderLeft.setDistancePerPulse(distancePerPulse);
		encoderRight.setDistancePerPulse(distancePerPulse);
	}
	
	public double distance() {
		return (encoderLeft.getDistance() + encoderRight.getDistance()) / 2; 
	}
	public void reset() {
		encoderLeft.reset();
		encoderRight.reset();
	}

	//random method you must use
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
