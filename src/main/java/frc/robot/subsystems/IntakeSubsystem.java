// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntakeSubsystem extends SubsystemBase {
  private static final WPI_TalonFX inTakeMotor= RobotMap.inTakeMotor;

  /** Creates a new Intake. */
  public IntakeSubsystem() {
    inTakeMotor.setNeutralMode(NeutralMode.Coast);
  }
  public static void setIntakeSpeed(double intakeSpeed){
    inTakeMotor.set(intakeSpeed);
  }

  public static void stop(){
    setIntakeSpeed(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
