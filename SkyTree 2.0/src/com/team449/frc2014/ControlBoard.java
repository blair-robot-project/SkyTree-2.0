package com.team449.frc2014;

import com.team449.lib.util.Util;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Neat and tidy place for all the joysticks
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class ControlBoard {
    
    private final Joystick j_1 = new Joystick(Constants.joystick1Port.getInt());
    private final Joystick j_2 = new Joystick(Constants.joystick2Port.getInt());
    private final Joystick j_3 = new Joystick(Constants.joystick3Port.getInt());
    private final Joystick j_4 = new Joystick(Constants.joystick4Port.getInt());
    
    public double getDriveJoyX(){
        double joyX = j_2.getAxis(Joystick.AxisType.kX);
        return Util.deadBand(joyX * Constants.jXGain.getDouble());
    }
    
    public double getDriveJoyY(){
        double joyY = j_2.getAxis(Joystick.AxisType.kY);
        return Util.deadBand(joyY * Constants.jYGain.getDouble());
    }
    
    public boolean getFShoot(){
        return j_4.getRawButton(Constants.fShootButton.getInt());
    }
    
    public double getShotPower(){
        return j_1.getThrottle();
    }
    
    public boolean getSafety(){
        return j_3.getRawButton(Constants.safetyButton.getInt());
    }
    
    public boolean getArmIn(){
        return j_2.getRawButton(Constants.armInButton.getInt());
    }
    
    public boolean getFullFore(){
        return j_3.getRawButton(Constants.fullForeButton.getInt());
    }
    
    public boolean getFullBack(){
        return j_3.getRawButton(Constants.fullBackButton.getInt());
    }
    
    public boolean getHalfFore(){
        return j_3.getRawButton(Constants.halfForeButton.getInt());
    }
    
    public boolean getDefault(){
        return j_4.getRawButton(Constants.defaultButton.getInt());
    }
    
    public boolean getClosed(){
        return j_4.getRawButton(Constants.closedButton.getInt());
    }
    
    public boolean getCatch(){
        return j_4.getRawButton(Constants.closedButton.getInt());
    }
    
    public boolean getCShoot(){
        return j_4.getRawButton(Constants.cShootButton.getInt()) ||
                getFShoot() || getSafety();
    }
    
}
