package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoSelector extends CommandGroup {

	private char location = ' ';
	private char targetSide = ' ';
	private char oppositeTargetSide = ' ';

	public AutoSelector() { 
		System.out.println("instance created");

		location = RobotMap.location;
		targetSide = RobotMap.targetSide;
		if (targetSide == 'L') { oppositeTargetSide = 'R'; }
		driveToTarget();
	}
	
/*	private void deliverCube() {
		if (RobotMap.targetScale) {
			System.out.println("Lift mechanism command");
		} 
		System.out.println("Deliver cube command");	
	}
*/

	public void driveToTarget() {
		addSequential(new DriveStop(RobotMap.delayInSeconds));
		
		SmartDashboard.putString("Indrivetotargetloc", String.valueOf(location));
		SmartDashboard.putString("InDrivetotargettarget", String.valueOf(targetSide));

		
		// Determine path to target based on starting position of robot
		switch(location) {
		case 'C':
			System.out.println("In case c");
			addSequential(new DriveStraight(.4,4));
			if (targetSide == 'L') {
				addSequential(new DriveTurn(-.4,4));
				
				if(RobotMap.targetScale) addSequential(new DriveStraight(.4,8));
				else addSequential(new DriveStraight(0.4, 3));
				
				addSequential(new DriveTurn(.4,5));
			} else {
				addSequential(new DriveTurn(.4,2));
				
				if(RobotMap.targetScale) addSequential(new DriveStraight(0.4,8));
				else addSequential(new DriveStraight(0.4, 5));

				addSequential(new DriveTurn(-.4,5));
			}
			//deliverCube();
			break;
		case 'L':
			System.out.println("In case l");
			addSequential(new DriveTurn(-.4,5));
			
			if (targetSide == 'L') {
				if(RobotMap.targetScale) addSequential(new DriveStraight(.4,8));
				else addSequential(new DriveStraight(0.4, 5));
			} else {
				addSequential(new DriveStop(0));
				//driveAroundSwitch('R');
			/*OPPOSITE SIDE SCALE
				if(RobotMap.targetScale) addSequential(new DriveStraight(.3,8));
				else addSequential(new DriveStraight(0.3, 5));
			}
			*/
			//deliverCube();
			break;
			}
		case 'R':
			System.out.println("In case r");

			addSequential(new DriveTurn(.4,5));
			if (targetSide == 'R') {
				
				if(RobotMap.targetScale) addSequential(new DriveStraight(.4,8));
				else addSequential(new DriveStraight(0.4, 5));
				
			} else {
				addSequential(new DriveStop(0));
		/*OPPOSITE SIDE SCALE
				//driveAroundSwitch('L');
				addSequential(new DriveStraight(.3,5));
				addSequential(new DriveTurn(.3,5));
				*/
			}
			//deliverCube();
			break;
		default:
			System.out.println("Drive Forward");
	    	addSequential(new DriveStraight(.3,5));
			break;
		} 		
	}
}