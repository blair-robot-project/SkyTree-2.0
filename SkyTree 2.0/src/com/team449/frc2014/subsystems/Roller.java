package com.team449.frc2014.subsystems;

import com.team449.frc2014.Constants;
import com.team449.frc2014.commands.CommandBase;
import com.team449.lib.util.ConstantsBase;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Roller subsystem
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class Roller extends Subsystem {
    
    private CANJaguar arm_motor;
    private DoubleSolenoid arm = new DoubleSolenoid(Constants.armSlndMod.getInt(),
            Constants.armFwdChnl.getInt(), Constants.armRevChnl.getInt());
    
    private boolean lastVal = false;
    private boolean lastFlingShoot = false;
    private boolean lastArmIn = false;
    private Timer t = new Timer();
    
    public Roller(){
        
        // Arm motor initialization
        try {
            arm_motor = new CANJaguar(Constants.armMtrNum.getInt(),
                    CANJaguar.ControlMode.kVoltage);
            arm_motor.configNeutralMode(CANJaguar.NeutralMode.kBrake);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
        // Arm Solenoid setting
        arm.set(DoubleSolenoid.Value.kReverse);
        t.start();
    }
    
    public CANJaguar getArmMotor(){
        return arm_motor;
    }
    
    public void setArmMotor(double value) throws CANTimeoutException {
        arm_motor.setX(value);
    }
    
    public DoubleSolenoid getArm(){
        return arm;
    }
    
    public void setArm(DoubleSolenoid.Value value){
        arm.set(value);
    }
    
    public void recalc(boolean flingShoot) throws CANTimeoutException {
        boolean armIn = CommandBase.controlBoard.getArmIn();
        boolean val = !lastVal && (!lastFlingShoot && flingShoot) ||
                (armIn && !lastArmIn);
        boolean value = val ? !lastVal : lastVal;
        
        // Arm calc
        if (value) setArm(DoubleSolenoid.Value.kForward);
        else setArm(DoubleSolenoid.Value.kReverse);
        
        // Motor calc
        if (!lastVal && value) t.reset();
        double voltage;
        if (t.get() < 1000 || CommandBase.controlBoard.getFullFore())
            voltage = 12;
        else if(CommandBase.controlBoard.getFullBack()) voltage = -12;
        else if(CommandBase.controlBoard.getHalfFore()) voltage = 0;
        else voltage = 0.4;
        setArmMotor(voltage);
        
        lastVal = value;
        lastFlingShoot = flingShoot;
        lastArmIn = armIn;
    }
    
    public void initDefaultCommand() {
    }

}
