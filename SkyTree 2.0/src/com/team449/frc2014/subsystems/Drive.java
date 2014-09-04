package com.team449.frc2014.subsystems;

import com.team449.frc2014.Constants;
import com.team449.lib.util.CANPanther;
import com.team449.lib.util.Util;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drive Subsystem (All the drive stuff - Materials, methods, and the whatnot)
 * @author Eyob
 */
public class Drive extends Subsystem {
    
    private CANPanther left_1;
    private CANPanther left_2;
    private CANPanther left_3;
    private CANPanther right_1;
    private CANPanther right_2;
    private CANPanther right_3;
    
    private Encoder left_encoder = new Encoder(
            new DigitalOutput(Constants.enDIOMod.getInt(), Constants.enAChnl.getInt()),
            new DigitalOutput(Constants.enDIOMod.getInt(), Constants.enBChnl.getInt()),
            false, CounterBase.EncodingType.k4X);
    
    public Drive(){
        // Panther Initialization
        try {
            left_1 = new CANPanther(Constants.panthL1Num.getInt());
            left_2 = new CANPanther(Constants.panthL2Num.getInt());
            left_3 = new CANPanther(Constants.panthL3Num.getInt());
            right_1 = new CANPanther(Constants.panthR1Num.getInt());
            right_2 = new CANPanther(Constants.panthR2Num.getInt());
            right_3 = new CANPanther(Constants.panthR3Num.getInt());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
        // Encoder initial setting        
        left_encoder.setDistancePerPulse(Constants.enDPP.getDouble());
        left_encoder.setMinRate(Constants.enMinRt.getDouble());
        left_encoder.setSamplesToAverage(Constants.enNumSamp.getInt());
    }
    
    public double getLeftDist(){
        return left_encoder.get();
    }
    
    public void setLeft(double speed) throws CANTimeoutException{
        left_1.setX(speed);
        left_2.setX(speed);
        left_3.setX(speed);
    }
    
    public void setRight(double speed) throws CANTimeoutException{
        right_1.setX(speed);
        right_2.setX(speed);
        right_3.setX(speed);
    }
    
    public void setMotors(double jX, double jY) throws CANTimeoutException{
        double x = Util.deadBand(-jX);
        double y = Util.deadBand(jY);
        double left, right;
        
        if (y > 0){
            if (x > 0){
                left = y - x;
                right = Math.max(x, y);
            }
            else {
                left = Math.max(-x, y);
                right = x + y;
            }
        }
        else {
            if (x > 0){
                left = -(Math.max(x, -y));
                right = x + y;
            }
            else {
                left = y - x;
                right = Math.min(x, y);     // originally -Math.max(-x, -y);
            }
        }
        
        left *= 12; right *= 12;
        left *= Constants.leftGain.getDouble();
        
        setLeft(-left);
        setRight(right);
    }
    
    public void initDefaultCommand() {
        
    }
    
}