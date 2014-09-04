package com.team449.frc2014.subsystems;

import com.team449.frc2014.Constants;
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
    private DoubleSolenoid first = new DoubleSolenoid(Constants.solMod.getInt(),
            Constants.firstFwdChnl.getInt(), Constants.firstRevChnl.getInt());
    // side panels
    private Solenoid second = new Solenoid(Constants.solMod.getInt(),
            Constants.secondChnl.getInt());
    // contract everything
    private Solenoid third = new Solenoid(Constants.solMod.getInt(),
            Constants.thirdChnl.getInt());
    
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
    
    public void adjust(){
        String value;
        if (CommandBase.controlBoard.getDefault()) value = "default";
        else if (CommandBase.controlBoard.getClosed()) value = "closed";
        else if (CommandBase.controlBoard.getCatch()) value = "catch";
        else if (CommandBase.controlBoard.getCShoot()) value = "shoot";
        else value = lastVal;
        
        if (value.equals("default"))
            // Depressurize everything!!
            set(DoubleSolenoid.Value.kReverse, false, false);
        else if (value.equals("closed"))
            // Don't pressurize the first two solenoids, but close up
            // everything using the other solenoid
            set(DoubleSolenoid.Value.kReverse, false, true);
        else if (value.equals("catch")){
            // If last was not catch and this time is catch, then put out
            // the sides for a while but then depressurize everything
            if (!lastVal.equals("catch")) t.reset();
            if (t.get() < 1000) set(DoubleSolenoid.Value.kReverse, true, false);
            else set(DoubleSolenoid.Value.kReverse, false, false);
        }
        else if (value.equals("shoot"))
            // Put the front panel forward, but don't pressurize anything else
            set(DoubleSolenoid.Value.kForward, false, false);
        
        lastVal = value;
    }

    public void initDefaultCommand() {
    }
}
