/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;

//import frc.robot.subsystems.pnusub;

public class pnucommand extends Command {
  boolean tog0;
 boolean tog1;
 boolean tog2;
 boolean tog3;
 boolean tog4;

  public pnucommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pnuSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    tog0= true;
    tog1 = true;
    tog2=true;
    tog3 = true;
    tog4 = true;
   // Robot.pnuSubsystem.pnusub();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double tiltvalue = Robot.oi.xbox.getY(Hand.kLeft);
    Robot.pnuSubsystem.tiltaction(tiltvalue);

   
    if(Robot.oi.xbox.getBButtonPressed()){
      tog0 = !tog0;
      if(tog0){
        Robot.pnuSubsystem.retractVac();
      }if(!tog0){
        Robot.pnuSubsystem.extendVac();
      }      
    }

     if(Robot.oi.xbox.getBumperPressed(Hand.kRight)){
       tog1 = !tog1;
       Robot.pnuSubsystem.tiltLock(tog1);
     }
   
    if(Robot.oi.xbox.getXButtonPressed()){
     tog2= !tog2;
      Robot.pnuSubsystem.backDrop(tog2);
    }
    if(Robot.oi.xbox.getYButtonPressed()){
    tog3 = !tog3;
    Robot.pnuSubsystem.frontLift(tog3);
    }
    if(Robot.oi.xbox.getAButtonPressed()){
     
      Robot.pnuSubsystem.vacBreak(true);

    }
    if(Robot.oi.xbox.getAButtonReleased()){
      Robot.pnuSubsystem.vacBreak(false);
    }
    
    




    // boolean var;
    // var = Robot.oi.xbox.getAButtonPressed(); 
    // if(var){    //tilt lock
    // Robot.pnuSubsystem.tiltLock(var);
    // }
    // if(Robot.oi.xbox.getRawButton(1)){    //release
    //   Robot.pnuSubsystem.tiltLock(var);
    // }

    // if(Robot.oi.xbox.getRawButton(3)){ //to tilt
    //   Robot.pnuSubsystem.tiltaction(1); //forwardss
    // }else if(Robot.oi.xbox.getRawButton(2)){
    //   Robot.pnuSubsystem.tiltaction(2); //backwards
    // }else{
    //   Robot.pnuSubsystem.tiltaction(0);// stops tilt
    // }

    // if(Robot.oi.xbox.getRawButton(4)){ //liftfront
    //   var = Robot.oi.xbox.getRawButton(4);
    //   Robot.pnuSubsystem.frontLift(var);
    // }

    









  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.pnuSubsystem.tiltaction(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
