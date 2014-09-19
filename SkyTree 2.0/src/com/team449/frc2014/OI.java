
package com.team449.frc2014;

import com.team449.frc2014.commands.CatchCommand;
import com.team449.frc2014.commands.CloseCatcherCommand;
import com.team449.frc2014.commands.DepressurizeCatcherCommand;
import com.team449.frc2014.commands.OpenFrontPanelCommand;
import com.team449.frc2014.commands.ShootCommand;
import com.team449.frc2014.commands.TurnSafetyOnCommand;
import com.team449.lib.util.Util;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static boolean safety = false;
    
    private final Joystick j_1 = new Joystick(RobotMap.joystick1Port);
    private final Joystick j_2 = new Joystick(RobotMap.joystick2Port);
    private final Joystick j_3 = new Joystick(RobotMap.joystick3Port);
    private final Joystick j_4 = new Joystick(RobotMap.joystick4Port);
    
    private final Button[] j1_buttons = new Button[12];
    private final Button[] j2_buttons = new Button[12];
    private final Button[] j3_buttons = new Button[12];
    private final Button[] j4_buttons = new Button[12];
    
    public OI(){
        for (int i = 0; i <= 11; i++){
            j1_buttons[i] = new JoystickButton(j_1, i);
            j2_buttons[i] = new JoystickButton(j_2, i);
            j3_buttons[i] = new JoystickButton(j_3, i);
            j4_buttons[i] = new JoystickButton(j_4, i);
        }
        
        j4_buttons[RobotMap.fShootButton].whenReleased(new ShootCommand(false));
        j3_buttons[RobotMap.safetyButton].toggleWhenPressed(new TurnSafetyOnCommand());
        
        j4_buttons[RobotMap.defaultButton].whenPressed(new DepressurizeCatcherCommand());
        j4_buttons[RobotMap.closedButton].whenPressed(new CloseCatcherCommand());
        j4_buttons[RobotMap.catchButton].whenPressed(new CatchCommand());
        j4_buttons[RobotMap.cShootButton].whenPressed(new OpenFrontPanelCommand());
    }
    
    public double getDriveJoyX(){
        double joyX = j_2.getAxis(Joystick.AxisType.kX);
        return Util.deadBand(joyX * RobotMap.jXGain);
    }
    
    public double getDriveJoyY(){
        double joyY = j_2.getAxis(Joystick.AxisType.kY);
        return Util.deadBand(joyY * RobotMap.jYGain);
    }
    
}

