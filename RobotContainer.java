/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.GearShiftCommand;

import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
	// The robot's subsystems and commands are defined here...
	private final Joystick m_taranis = new Joystick(0);
	private final XboxController m_xbox = new XboxController(1);


	/**
	 * The container for the robot.  Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		// Configure the button bindings
		configureButtonBindings();
		m_taranis.setXChannel(3);
		m_taranis.setYChannel(2);
		m_driveTrain.setDefaultCommand(new DriveCommand(()->-m_taranis.getY(), ()->Math.abs(m_taranis.getRawAxis(1)) > Math.abs(m_taranis.getRawAxis(3)) ? m_taranis.getRawAxis(1) * 0.8 : m_taranis.getRawAxis(3) * 0.8, m_driveTrain));
	}

	/**
	 * Use this method to define your button->command mappings.  Buttons can be created by
	 * instantiating a {@link GenericHID} or one of its subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
	 * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */
	private void configureButtonBindings() {

//		new JoystickButton(m_xbox, Constants.kButtonShift).toggleWhenPressed(new GearShiftCommand(m_driveTrain));
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Joystick getTaranis(){
		return m_taranis;
	}

	public XboxController getXbox(){
		return m_xbox;
	}



	public Command getAutonomousCommand(){
		return new DriveCommand(()->0.3, ()->0, m_driveTrain);
	}



	public void onDisable(){
	
		m_driveTrain.drive(0, 0);
	
	}
}
