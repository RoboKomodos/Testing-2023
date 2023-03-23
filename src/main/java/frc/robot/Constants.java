package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Constants {

  // Speed Multiplier Variables
  public final double minMultiplier = 0.55;
  public final double maxMultiplier = 1;//0.85;

  // Arm/Claw Speed
  public final double armUpSpeed = 0.3;
  public final double armDownSpeed = -0.1;
  
  public final double clawOpenSpeed = 0.2;
  public final double clawCloseSpeed = -0.2;

  // Arm Motors
  public final PWMSparkMax leftArmMotor = new PWMSparkMax(3);
  public final PWMSparkMax rightArmMotor = new PWMSparkMax(4);

  // Claw Motors
  public final PWMSparkMax clawMotor = new PWMSparkMax(6);
    
}
