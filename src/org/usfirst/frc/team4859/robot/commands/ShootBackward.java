package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.Command;

public class ShootBackward extends Command {
	
	private double time = 0;
	
    public ShootBackward() {
    	requires(Robot.tunnel);
    	requires(Robot.lifter);
    	time = 0;
    }
    
    public ShootBackward(double inputTime) {
    	requires(Robot.tunnel);
    	requires(Robot.lifter);
    	time = inputTime;
    }

    protected void initialize() {
    	setTimeout(time);
    	Robot.lifter.liftToHeight(RobotMap.liftSetHeight);
    	System.out.println("ShootBackward command ran");
    }

    protected void execute() {
        if ((Lifter.motorLiftStage1.getSelectedSensorPosition(0) + Lifter.motorLiftStage2.getSelectedSensorPosition(0)) < 10000);
    	else Robot.tunnel.tunnelShoot(-RobotMap.kTunnelShootSpeed);
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.tunnel.tunnelStop();
    	Robot.lifter.liftDown(RobotMap.kLiftDownSpeed);
    }

    protected void interrupted() {
    	Robot.tunnel.tunnelStop();
    	Robot.lifter.liftDown(RobotMap.kLiftDownSpeed);
    }
}