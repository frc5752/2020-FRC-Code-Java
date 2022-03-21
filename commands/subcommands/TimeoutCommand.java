/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.subcommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TimeoutCommand extends CommandBase {
	private double duration;
	private Timer timer;

	public TimeoutCommand(double duration) {
		this.duration = duration;
		timer = new Timer();
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		timer.reset();
		timer.start();
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return timer.hasPeriodPassed(duration);
	}
}
