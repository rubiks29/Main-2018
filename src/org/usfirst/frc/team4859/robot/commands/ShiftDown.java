package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.command.Command;

public class ShiftDown extends Command {
	
	public ShiftDown() {
    	requires(Robot.shifters);
    }

    protected void initialize() {
    	Robot.shifters.pneumaticShiftDown();
		Drivetrain.motorLeftMaster.configMotionAcceleration(RobotMap.kLowGearAcceleration, RobotMap.kTimeoutMs);
		Drivetrain.motorRightMaster.configMotionCruiseVelocity(RobotMap.kLowGearCruiseVelocity, RobotMap.kTimeoutMs);
		System.out.println("ShiftDown command ran");
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
    	Robot.shifters.pneumaticShiftDown();
    }

    protected void interrupted() {
    }
}