/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class GearShiftCommand extends CommandBase {
	//Shifts into a higher gear when active and back down to a lower gear when ended
	private DriveTrain m_driveTrain;

	public GearShiftCommand(DriveTrain driveTrain) {
		m_driveTrain = driveTrain;
		addRequirements(m_driveTrain);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		m_driveTrain.shift(true);
	}

	// Called once the command ends or is interrupted.
	@Override
public void end(boolean interrupted) {
		m_driveTrain.shift(false);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
