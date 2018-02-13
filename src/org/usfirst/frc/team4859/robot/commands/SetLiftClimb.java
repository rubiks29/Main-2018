package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class SetLiftClimb extends Command {
    
    public SetLiftClimb() {
    }

    protected void initialize() {
    	RobotMap.liftSetHeight = Robot.liftEncoderUnitConversion(RobotMap.liftClimbHeight);
    	System.out.println("SetLiftClimb command ran");
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}