package com.team449.frc2014;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Neat and tidy place for all the joysticks
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class ControlBoard {
    
    private final Joystick j_1 = new Joystick(RobotMap.joystick1Port);
    private final Joystick j_2 = new Joystick(RobotMap.joystick2Port);
    private final Joystick j_3 = new Joystick(RobotMap.joystick3Port);
    private final Joystick j_4 = new Joystick(RobotMap.joystick4Port);
    
    public boolean getFShoot(){
        return j_4.getRawButton(RobotMap.fShootButton);
    }
    
    public boolean getArmIn(){
        return j_2.getRawButton(RobotMap.armInButton);
    }
    
    public boolean getFullFore(){
        return j_3.getRawButton(RobotMap.fullForeButton);
    }
    
    public boolean getFullBack(){
        return j_3.getRawButton(RobotMap.fullBackButton);
    }
    
    public boolean getHalfFore(){
        return j_3.getRawButton(RobotMap.halfForeButton);
    }
    
}
