package com.team449.frc2014.commands;

import com.team449.frc2014.ControlBoard;
import com.team449.frc2014.OI;
import com.team449.frc2014.RobotMap;
import com.team449.frc2014.subsystems.Catcher;
import com.team449.frc2014.subsystems.Drive;
import com.team449.frc2014.subsystems.Flinger;
import com.team449.frc2014.subsystems.Roller;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    public static Drive drive = new Drive();
    public static Roller roller = new Roller();
    public static Flinger flinger = new Flinger();
    public static Catcher catcher = new Catcher();
    public static ControlBoard controlBoard; // Just driver station
    public static Compressor comp = new Compressor(RobotMap.compDigMod,
            RobotMap.compDIO, RobotMap.compDigMod, RobotMap.compRelay);

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        
        controlBoard = new ControlBoard();
        comp.start();
        
        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData((NamedSendable) controlBoard);
    }

}
