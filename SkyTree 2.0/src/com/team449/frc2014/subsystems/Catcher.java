package com.team449.frc2014.subsystems;

import com.team449.frc2014.RobotMap;
import com.team449.frc2014.commands.CommandBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Catcher Subsystem -- Probably shouldn't use generic get-set for the real deal
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class Catcher extends Subsystem {
    
    // front panel
    private DoubleSolenoid first = new DoubleSolenoid(RobotMap.solMod,
            RobotMap.firstFwdChnl, RobotMap.firstRevChnl);
    // side panels
    private Solenoid second = new Solenoid(RobotMap.solMod, RobotMap.secondChnl);
    // contract everything
    private Solenoid third = new Solenoid(RobotMap.solMod, RobotMap.thirdChnl);
    
    private String lastVal = "closed";
    private Timer t = new Timer();
    
    public Catcher(){
        first.set(DoubleSolenoid.Value.kReverse);
        second.set(false);
        third.set(true);
        t.start();
    }
    
    public void set(DoubleSolenoid.Value first, boolean second, boolean third){
        setFirst(first);
        setSecond(second);
        setThird(third);
    }
    
    public void setFirst(DoubleSolenoid.Value value){
        first.set(value);
    }
    
    public void setSecond(boolean set){
        second.set(set);
    }
    
    public void setThird(boolean set){
        third.set(set);
    }

    public void initDefaultCommand() {
    }
}
