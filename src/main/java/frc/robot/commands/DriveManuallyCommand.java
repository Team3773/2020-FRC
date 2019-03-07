/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
//import frc.robot.subsystems.DriveSubsystem;
//import edu.wpi.first.wpilibj.GenericHID.Hand;

public class DriveManuallyCommand extends Command {
  public DriveManuallyCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   // Robot.driveSubsystem.DriveSubsystem();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //double xboxval = Robot.oi.xbox.getY(Hand.kLeft);
   // Robot.driveSubsystem.movearm(xboxval);

    double move = -Robot.oi.stick.getY();
    double turn = Robot.oi.stick.getX();
    Robot.driveSubsystem.driveManually(move, turn);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveSubsystem.driveManually(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}