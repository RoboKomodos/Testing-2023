// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */                                                                            
public class Robot extends TimedRobot {

  // Motors 
  public final PWMSparkMax leftMotor = new PWMSparkMax(0);
  public final PWMSparkMax rightMotor = new PWMSparkMax(1);

  // Drivetrain
  public final DifferentialDrive robotDrive = new DifferentialDrive(leftMotor, rightMotor);

  //Controller Constants
  public final XboxController xbox = new XboxController(2);

  final Constants cons = new Constants();
  final Gear gear = new Gear();

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    rightMotor.setInverted(true);
  }


  @Override
  public void teleopInit()
  {

  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    double speedMultiplier = gear.getSpeedMultiplier();
    robotDrive.arcadeDrive(xbox.getLeftY() * speedMultiplier, -xbox.getLeftX() * speedMultiplier);

    if (xbox.getBButtonPressed() == true) {
      // Gear Shift Logic
      if (speedMultiplier > 0.7) {
        gear.setSpeedMultiplier(cons.minMultiplier);
      } else {
        gear.setSpeedMultiplier(cons.maxMultiplier);
      }
    }

    if (xbox.getPOV() == 0) {
      cons.leftArmMotor.set(cons.armUpSpeed);
      cons.rightArmMotor.set(cons.armUpSpeed);
    } else if (xbox.getPOV() == 180) {
      cons.leftArmMotor.set(cons.armDownSpeed);
      cons.rightArmMotor.set(cons.armDownSpeed);
    } else {
      cons.leftArmMotor.set(0);
      cons.rightArmMotor.set(0);
    }

  }
}
