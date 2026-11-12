// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shoot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */

// this is where we declared our controller CONTROLLER NEXT Line down 
public class RobotContainer {

  /* 
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
*/
// the controller object is instansiated 
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

// New drivtrain Mechanism is instansiated 
private final Drive mDrive = new Drive();

// we initialize our intake here 
Intake mIntake = new Intake();

//we initialize our shooter here 
Shoot mShoot = new Shoot();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
// still need to understand ts bro -> 
    mDrive.setDefaultCommand(
      new edu.wpi.first.wpilibj2.command.RunCommand
    (
    () -> mDrive.arcadeDrive(-m_driverController.getLeftY(),m_driverController.getRightX()) , mDrive 
    )
    );
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  
  private void configureBindings()
  {
    // this is used to configure Buttons on the controller 

    // this specific method configures the Left bumper
    // Run End basically adds an action when run and when the action ends , the action in this case being the enabling of the intake button 
    m_driverController.leftBumper().whileTrue
    (mIntake.runEnd(() -> mIntake.spinup(Constants.OperatorConstants.intakeSpeed),() -> mIntake.spindown(0) ));

    // This is used to configure the right bumper which shoots while outputting fuel into the shooter 
    m_driverController.rightBumper().whileTrue
    (   mShoot.runEnd(()->mShoot.shoot(),()->mShoot.stopShoot()).alongWith(
        mIntake.runEnd(()->mIntake.spinup(-1),()->mIntake.spindown(0))));
      
      
      
      }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
   // return Autos.exampleAuto(m_exampleSubsystem);
   return null;
  }
}
