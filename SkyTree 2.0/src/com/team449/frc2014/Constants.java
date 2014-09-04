/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.team449.frc2014;

import com.team449.lib.util.ConstantsBase;

/**
 * All constants used in the robot defined right here
 * And, yes, I used my own listing system because I'm cool
 * @author Eyob
 */
public final class Constants extends ConstantsBase {
    
    //------------------------General Constants--------------------------//
    
    // Joystick ports
    public static final Constant joystick1Port = new Constant("j1port", 1);
    public static final Constant joystick2Port = new Constant("j2port", 2);
    public static final Constant joystick3Port = new Constant("j3port", 3);
    public static final Constant joystick4Port = new Constant("j4port", 4);
    
    // Compressor values
    public static final Constant compRelay = new Constant("compRelay", 1);
    public static final Constant compDigMod = new Constant("compDigMod", 1);
    public static final Constant compDIO = new Constant("compDIO", 1);
    
    //-------------------------Drive Constants---------------------------//
    
    // CAN Panther values
    public static final Constant panthL1Num = new Constant("panthL1Num", 1);
    public static final Constant panthL2Num = new Constant("panthL2Num", 5);
    public static final Constant panthL3Num = new Constant("panthL3Num", 6);
    public static final Constant panthR1Num = new Constant("panthR1Num", 2);
    public static final Constant panthR2Num = new Constant("panthR2Num", 3);
    public static final Constant panthR3Num = new Constant("panthR3Num", 4);
    
    // Encoder values
    public static final Constant enDIOMod = new Constant("enDIOMod", 1);
    public static final Constant enAChnl = new Constant("enAChnl", 3);
    public static final Constant enBChnl = new Constant("enBChnl", 4);
    public static final Constant enDPP = new Constant("enDPP", 0.0020453);
    public static final Constant enMinRt = new Constant("enMinRt", 1);
    public static final Constant enNumSamp = new Constant("enNumSamp", 10);
    
    // Joystick values
    public static final Constant jXGain = new Constant("jXGain", -0.75);
    public static final Constant jYGain = new Constant("jYGain", 1);
    
    // Motor values
    public static final Constant leftGain = new Constant("leftGein", 1);
    
    //------------------------Roller Constants---------------------------//
    
    // Buttons
    public static final Constant armInButton = new Constant("armInButton", 1);
    public static final Constant fullForeButton = new Constant("fullForeButton", 3);
    public static final Constant fullBackButton = new Constant("fullBackButton", 2);
    public static final Constant halfForeButton = new Constant("halfForeButton", 4);
    
    // CAN Jaguar number
    public static final Constant armMtrNum = new Constant("armMtrNum", 7);
    
    // Solenoid values
    public static final Constant armSlndMod = new Constant("armSlndMod", 2);
    public static final Constant armFwdChnl = new Constant("armFwdChnl", 2);
    public static final Constant armRevChnl = new Constant("armRevChnl", 3);
    
    //------------------------Flinger Constants--------------------------//
    
    // Buttons
    public static final Constant fShootButton = new Constant("fShootButton", 1);
    public static final Constant safetyButton = new Constant("safetyButton", 1);
    
    // Solenoid values
    public static final Constant flingSolChnl = new Constant("flingSolChnl", 1);
    
    //------------------------Catcher Constants--------------------------//
    
    // Buttons
    public static final Constant defaultButton = new Constant("defaultButton", 2);
    public static final Constant closedButton = new Constant("closedButton", 3);
    public static final Constant catchButton = new Constant("catchButton", 4);
    public static final Constant cShootButton = new Constant("cShootButton", 5);
    
    // (Dbl and Single) Solenoid values
    public static final Constant firstFwdChnl = new Constant("firstFwdChnl", 6);
    public static final Constant firstRevChnl = new Constant("firstRevChnl", 5);
    public static final Constant secondChnl = new Constant("secondChnl", 8);
    public static final Constant thirdChnl = new Constant("thirdChnl", 4);
    
    //-------------------- Miscellaneous Constants-----------------------//
    
    // CAN Panther
    public static final Constant panthRmpRt = new Constant("panthRmpRt", 96);
    
    // Solenoid
    public static final Constant solMod = new Constant("solMod", 2);
    
    // Joystick
    public static final Constant joyDeadBand = new Constant("joyDeadBand", 0.01);
    
    static {
        resetConstants();
    }
    
}
