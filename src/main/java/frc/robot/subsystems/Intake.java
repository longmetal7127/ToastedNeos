package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;

import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants;

public class Intake extends SubsystemBase {
    //Declares the sparkflex object , this is our actual motor 
SparkFlex intakeFlex = new SparkFlex(Constants.OperatorConstants.CANIntake, MotorType.kBrushless);

// Configures our motors data , think of it like a sticky note with info on what the motor should be set to 
SparkFlexConfig intakeConfig = new SparkFlexConfig();

public Intake()
{
intakeConfig.smartCurrentLimit(40); // limits motor current 
intakeFlex.configure(intakeConfig, SparkFlex.ResetMode.kResetSafeParameters ,SparkFlex.PersistMode.kPersistParameters);
}
public void setIntakeSpeed(double speed)
{ 
    intakeFlex.set(Constants.OperatorConstants.intakeSpeed);
}
    
}
