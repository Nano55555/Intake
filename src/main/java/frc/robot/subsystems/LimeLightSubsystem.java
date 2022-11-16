// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LimelightConstants;

public class LimeLightSubsystem extends SubsystemBase {
  /** Creates a new LimeLight. */
  public static NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
  public static NetworkTableEntry tx = limelightTable.getEntry("tx");
  public static NetworkTableEntry ty = limelightTable.getEntry("tx");
  
  public static double limelight_x=(Double) tx.getDouble(0.0);
  public static double limelight_y=(Double) ty.getDouble(0.0);

  public LimeLightSubsystem() {
    limelightTable.getEntry("ledMode").setNumber(LimelightConstants.FORCE_OFF);   
    limelightTable.getEntry("camMode").setNumber(LimelightConstants.DRIVER_CAMERA);
  }

  public static void getLimeLightData(){
    limelight_x= (Double) limelightTable.getEntry("tx").getDouble(0.0);
    limelight_y= (Double) limelightTable.getEntry("ty").getDouble(0.0);
  }

  public static double getLimelightX(){
    return (Double) limelightTable.getEntry("tx").getDouble(0.0);
  }

  public static double getLimelightY(){
    return (Double) limelightTable.getEntry("ty").getDouble(0.0);
}

  public static void turn_LED_ON(){
    limelightTable.getEntry("ledMode").setNumber(LimelightConstants.FORCE_ON);
  }

  public static void setVisionProcessor() {
    limelightTable.getEntry("camMode").setNumber(LimelightConstants.VISION_PROCESSOR);
    turn_LED_ON();
  }

  public static double getHorizontalDistance() {
    double targetOffsetAngle_Vertical = getLimelightY();
    double limelightMountAngleDegrees = 30;
    double limelightHeight= 1.0922;
    double goalHeight= 2.6416;
    double angleGoal= limelightMountAngleDegrees + targetOffsetAngle_Vertical;
    double angletoGoalRadians= angleGoal + (Math.PI / 180.0);
    double distance = (goalHeight - limelightHeight /Math.tan(angletoGoalRadians));
    return distance;
  }

  public static boolean isWithinDistance(){
    return(getHorizontalDistance() <= 5 && getHorizontalDistance() >= 1.7);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
