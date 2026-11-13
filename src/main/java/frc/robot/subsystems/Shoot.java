package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants; ;

public class Shoot extends SubsystemBase 
{

// declaring our motors to use for the shooter 
 SparkMax shoot1 = new SparkMax(Constants.OperatorConstants.CANShooter1,MotorType.kBrushless);
 SparkMax shoot2 = new SparkMax(Constants.OperatorConstants.CANShooter2,MotorType.kBrushless);
 SparkMaxConfig C_Shoot1 = new SparkMaxConfig();
 SparkMaxConfig C_Shoot2 = new SparkMaxConfig();

public Shoot() {
C_Shoot2.follow(shoot1,true);
shoot2.configure(C_Shoot1, ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
}
//fix shoot because intake needs to be running here as well 

//Command to shoot 
public void shoot () 
{shoot1.set(Constants.OperatorConstants.Shooterspeed);}

//command to stop the shooter 
public void stopShoot () 
{shoot1.set(0);}
}