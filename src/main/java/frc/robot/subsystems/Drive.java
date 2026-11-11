package frc.robot.subsystems;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants;;

public class Drive extends SubsystemBase {
    //////////////////////////////////////////////////////////
private SparkMax LeftLeader;
private SparkMax Leftfollower;
private SparkMax RightLeader;
private SparkMax Rightfollower;

DifferentialDrive mDrive;
 public Drive() 
 {

    // In this section we declare and configure our motors and sparkmax inversion values , this allows us to control what direction the power is directed in 

LeftLeader = new SparkMax(Constants.OperatorConstants.CANleftLeader, MotorType.kBrushless);
Leftfollower = new SparkMax(Constants.OperatorConstants.CANleftFollower, MotorType.kBrushless);
RightLeader = new SparkMax(Constants.OperatorConstants.CANrightLeader, MotorType.kBrushless);
Rightfollower= new SparkMax(Constants.OperatorConstants.CANrightFollower, MotorType.kBrushless);


SparkMaxConfig leftFollowerSparkMaxConfig = new SparkMaxConfig();
leftFollowerSparkMaxConfig.follow(LeftLeader);
Leftfollower.configure(leftFollowerSparkMaxConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

SparkMaxConfig rightLeaderSparkMaxConfig = new SparkMaxConfig();
rightLeaderSparkMaxConfig.inverted(true);
RightLeader.configure(rightLeaderSparkMaxConfig,SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

SparkMaxConfig rightFollowerSparkMaxConfig = new SparkMaxConfig();
rightFollowerSparkMaxConfig.follow(RightLeader);
Rightfollower.configure(rightFollowerSparkMaxConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

// this is where we configure arcade drive which uses our motors to give us a working drivetrain 
mDrive = new DifferentialDrive(LeftLeader, RightLeader);


 }


public void arcadeDrive (double speed , double rotation )
{
mDrive.arcadeDrive(speed, rotation);
}
 
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */

  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  //////////////////////////////////////////////////////////

    
}
