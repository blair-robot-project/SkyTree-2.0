package com.team449.lib.util;

import com.team449.frc2014.RobotMap;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 * Cool class for our specific jaguars
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class CANPanther extends CANJaguar {
    
    
    private static final CANJaguar.ControlMode panthCtrlMode = CANJaguar.ControlMode.kVoltage;    
    private static final CANJaguar.NeutralMode panthNtrlMode = CANJaguar.NeutralMode.kBrake;
    
    /**
    * Want to ignore other initialization possibilities 
    */
    public CANPanther(int deviceNumber) throws CANTimeoutException{
        super(deviceNumber, CANPanther.panthCtrlMode);
        this.enableControl();
        this.setVoltageRampRate(RobotMap.panthRmpRt);
        this.configNeutralMode(panthNtrlMode);
    }

}