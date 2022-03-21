/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
	public static final int kMotorIDBackLeft = 1;      //Spark
	public static final int kMotorIDFrontLeft = 2;     //Spark
	public static final int kMotorIDFrontRight = 3;    //Spark
	public static final int kMotorIDBackRight = 4;     //Spark
	//public static final int kMotorIDShooterTop = 4;    //Talon
	//public static final int kMotorIDShooterBottom = 3; //Talon
	//public static final int kMotorIDColorWheel = 1;    //Talon
//	public static final int kMotorIDElevator = 2;      //Talon
	//public static final int kMotorIDClimberWinch = 2;  //Victor
//	public static final int kMotorIDIntake = 1;        //Victor

	public static final int[] kSolenoidIDIntake = {2, 3};
	public static final int kSolenoidIDGearShiftRight = 0;
	public static final int kSolenoidIDShooter = 1;

	public static final int kButtonShoot = 1; //A
	public static final int kButtonLowShoot = 2; //B
	public static final int kButtonShift = 3; //X
}
