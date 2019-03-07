/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
//import frc.robot.Robot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManuallyCommand;

public class DriveSubsystem extends Subsystem {
  WPI_TalonSRX leftMaster = null;
  WPI_TalonSRX leftSlave = null;
  WPI_TalonSRX rightMaster = null;
  WPI_TalonSRX rightSlave = null;
  DifferentialDrive drive = null;
  //WPI_TalonSRX thing = null;

  public DriveSubsystem () {
    WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
    WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
    SpeedControllerGroup leftSide = new SpeedControllerGroup(leftMaster, leftSlave);
  
    WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
    WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);
    SpeedControllerGroup rightSide = new SpeedControllerGroup(rightMaster, rightSlave);

    // thing = new WPI_TalonSRX(RobotMap.tiltmotorPort);
  
    drive = new DifferentialDrive(leftSide, rightSide);
    drive.setSafetyEnabled(false);    
  }

  public void driveManually(double move, double turn) {
    //leftSlave.follow(leftMaster);
   // rightSlave.follow(rightMaster);
    drive.arcadeDrive(move, turn);
  }

  // public void movearm(double val){
  //   thing.set(val);
  // }
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManuallyCommand());
    //setDefaultCommand(new ());
  }
}