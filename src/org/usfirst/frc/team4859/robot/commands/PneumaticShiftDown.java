package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PneumaticShiftDown extends Command {

	private double time;
	
    public PneumaticShiftDown(double d) {
    	requires(Robot.pneumatics);
    	time = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.pneumatics.pneumaticShiftDown();
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
