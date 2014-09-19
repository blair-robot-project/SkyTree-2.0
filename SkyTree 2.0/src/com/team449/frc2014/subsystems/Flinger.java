package com.team449.frc2014.subsystems;

import com.team449.frc2014.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Flinger subsystem
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class Flinger extends Subsystem {
    
    private Solenoid flingSol = new Solenoid(RobotMap.solMod,
            RobotMap.flingSolChnl);
    private boolean status;
    
    public Flinger(){
        flingSol.set(false);
    }
    
    public void setStatus(boolean b){
        status = b;
    }
    
    public void setFlinger(boolean on){
        flingSol.set(on);
    }

    public void initDefaultCommand() {
    }
}
