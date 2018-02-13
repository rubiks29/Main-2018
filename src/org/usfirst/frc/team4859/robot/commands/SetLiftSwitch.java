package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class SetLiftSwitch extends Command {
    
    public SetLiftSwitch() {
    }

    protected void initialize() {
    	RobotMap.liftSetHeight = Robot.liftEncoderUnitConversion(RobotMap.liftSwitchHeight);
    	System.out.println("SetLiftSwitch command ran");
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