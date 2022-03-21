/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase {
	private DriveTrain m_driveTrain;
	private DoubleSupplier speed;
	private DoubleSupplier rotation;

	public DriveCommand(DoubleSupplier speed, DoubleSupplier rotation, DriveTrain driveTrain){
		// Use addRequirements() here to declare subsystem dependencies.
		m_driveTrain = driveTrain;
		this.speed = speed;
		this.rotation = rotation;
		addRequirements(m_driveTrain);
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		 if(Math.abs(m_driveTrain.getRightVelocity()) > m_driveTrain.getShiftSpeed() || Math.abs(m_driveTrain.getLeftVelocity()) > m_driveTrain.getShiftSpeed()) {
		 	m_driveTrain.shift(true);
		 }
		 else{
		 	m_driveTrain.shift(false);
		 }

		
		m_driveTrain.drive(speed.getAsDouble(), rotation.getAsDouble());
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
