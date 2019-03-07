/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.pnucommand;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;

/**
 * Add your docs here.
 */
public class pnusub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
 
  

Compressor airCompressor = null;
//Compressor vacPump = new Compressor(RobotMap.vacPumponPort);
Relay vacRelay = null;    
Solenoid frontlift = null;
Solenoid rearDrop = null;
Solenoid releaseVac = null;
Solenoid tiltLockThing = null;
DoubleSolenoid extendVacuumCups = null;
WPI_TalonSRX tiltMotor = null;

public pnusub(){
airCompressor = new Compressor(RobotMap.pcmNum);

vacRelay = new Relay(RobotMap.vacPumponPort);    
  
frontlift = new Solenoid(RobotMap.pcmNum,RobotMap.frontLiftPort);
rearDrop = new Solenoid(RobotMap.pcmNum,RobotMap.rearDropPort);
releaseVac = new Solenoid(RobotMap.pcmNum,RobotMap.vacPumpoffPort);
tiltLockThing = new Solenoid(RobotMap.pcmNum,RobotMap.tiltLock);
  
extendVacuumCups = new DoubleSolenoid(RobotMap.pcmNum,RobotMap.extendVacPort,RobotMap.retractVacPort);
  
tiltMotor = new WPI_TalonSRX(RobotMap.tiltmotorPort);

tiltMotor.setSafetyEnabled(false);
airCompressor.start(); 
vacRelay.set(Relay.Value.kForward); //kOn Kbackward
airCompressor.setClosedLoopControl(true);

}

// exampleDouble.set(DoubleSolenoid.Value.kOff);
// exampleDouble.set(DoubleSolenoid.Value.kForward);
// exampleDouble.set(DoubleSolenoid.Value.kReverse);
public void tiltLock(boolean var){
  tiltLockThing.set(var);
}
public void tiltaction(double var){
  
  
    tiltMotor.set(var);
}
public void frontLift(boolean var){
frontlift.set(var);
}
public void backDrop(boolean var){
rearDrop.set(var);
}
public void extendVac(){
  extendVacuumCups.set(DoubleSolenoid.Value.kForward);
}
public void retractVac(){
  extendVacuumCups.set(DoubleSolenoid.Value.kReverse);
}

public void vacBreak(boolean var){
  releaseVac.set(var);
}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new pnucommand());
  }
}
