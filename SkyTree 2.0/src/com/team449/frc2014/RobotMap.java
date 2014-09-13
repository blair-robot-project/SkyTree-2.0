package com.team449.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //------------------------General Constants--------------------------//
    
    // Joystick ports
    public static final int joystick1Port = 1;
    public static final int joystick2Port = 2;
    public static final int joystick3Port = 3;
    public static final int joystick4Port = 4;
    
    // Compressor values
    public static final int compRelay = 1;
    public static final int compDigMod = 1;
    public static final int compDIO = 1;
    
    //-------------------------Drive Constants---------------------------//
    
    // CAN Panther values
    public static final int panthL1Num = 1;
    public static final int panthL2Num = 5;
    public static final int panthL3Num = 6;
    public static final int panthR1Num = 2;
    public static final int panthR2Num = 3;
    public static final int panthR3Num = 4;
    
    // Encoder values
    public static final int enDIOMod = 1;
    public static final int enAChnl = 3;
    public static final int enBChnl = 4;
    public static final double enDPP = 0.0020453;
    public static final int enMinRt = 1;
    public static final int enNumSamp = 10;
    
    // Joystick values
    public static final double jXGain = -0.75;
    public static final int jYGain = 1;
    
    // Motor values
    public static final int leftGain = 1;
    
    //------------------------Roller Constants---------------------------//
    
    // Buttons
    public static final int armInButton = 1;
    public static final int fullForeButton = 3;
    public static final int fullBackButton = 2;
    public static final int halfForeButton = 4;
    
    // CAN Jaguar number
    public static final int armMtrNum = 7;
    
    // Solenoid values
    public static final int armSlndMod = 2;
    public static final int armFwdChnl = 2;
    public static final int armRevChnl = 3;
    
    //------------------------Flinger Constants--------------------------//
    
    // Buttons
    public static final int fShootButton = 1;
    public static final int safetyButton = 1;
    
    // Solenoid values
    public static final int flingSolChnl = 1;
    
    //------------------------Catcher Constants--------------------------//
    
    // Buttons
    public static final int defaultButton = 2;
    public static final int closedButton = 3;
    public static final int catchButton = 4;
    public static final int cShootButton = 5;
    
    // (Dbl and Single) Solenoid values
    public static final int firstFwdChnl = 6;
    public static final int firstRevChnl = 5;
    public static final int secondChnl = 8;
    public static final int thirdChnl = 4;
    
    //-------------------- Miscellaneous Constants-----------------------//
    
    // CAN Panther
    public static final int panthRmpRt = 96;
    
    // Solenoid
    public static final int solMod = 2;
    
    // Joystick
    public static final double joyDeadBand = 0.01;
}
