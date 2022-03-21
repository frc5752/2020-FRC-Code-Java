/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
	private static final int kNeoFreeSpeed = 5676; //rpm
	private static final double kHighGearRatio = 7.95;
	private static final double kLowGearRatio = 16.36;

	private double speed;
	private double rotation;
	private static final Solenoid gearSolenoid = new Solenoid(Constants.kSolenoidIDGearShiftRight);
	private static final CANSparkMax backLeftController = new CANSparkMax(Constants.kMotorIDBackLeft, MotorType.kBrushless);
	private static final CANSparkMax frontLeftController = new CANSparkMax(Constants.kMotorIDFrontLeft, MotorType.kBrushless);
	private static final CANSparkMax backRightController = new CANSparkMax(Constants.kMotorIDBackRight, MotorType.kBrushless);
	private static final CANSparkMax frontRightController = new CANSparkMax(Constants.kMotorIDFrontRight, MotorType.kBrushless);
	private static final CANEncoder leftEncoder = frontLeftController.getEncoder();
	private static final CANEncoder rightEncoder = frontRightController.getEncoder();
	private SpeedControllerGroup leftMotorControllers = new SpeedControllerGroup(backLeftController, frontLeftController);
	private SpeedControllerGroup rightMotorControllers = new SpeedControllerGroup(backRightController, frontRightController);
	private DifferentialDrive drive = new DifferentialDrive(leftMotorControllers, rightMotorControllers);

	public DriveTrain() {}

	public void shift(boolean x) {
		gearSolenoid.set(x);
	}

	public void drive(double speed, double rotation) {
		this.speed = speed;
		this.rotation = rotation;
	}

	public double getShiftSpeed() {
		return kNeoFreeSpeed / (kLowGearRatio + kHighGearRatio);
	}

	public double getLeftVelocity() {
		return leftEncoder.getVelocity();
	}

	public double getRightVelocity() {
		return leftEncoder.getVelocity();
	}

	public double getAverageVelocity(){
		return (leftEncoder.getVelocity() + rightEncoder.getVelocity()) / 2;
	}

	@Override
	public void periodic() {
		drive.arcadeDrive(speed, rotation);
	}
}
