package com.team449.frc2014.commands.auto;

import com.team449.frc2014.commands.ExtendRetractArmCommand;
import com.team449.frc2014.commands.FrontPanelCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Some of this code may be irritating to look at because I didn't have
 * a good enough understanding of what we were doing during auto
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class AutonomousCommand extends CommandGroup {
    
    public BigAutoCheckCommand autoCheck = new BigAutoCheckCommand();
    
    public AutonomousCommand() {
        // May want to change to parallel -- Retract arm, extend front panel
        addSequential(new ExtendRetractArmCommand(false));
        addSequential(new FrontPanelCommand(true)); 
        addParallel(autoCheck);
        addParallel(new AdjustPositionCommand());
        addParallel(new ShootOnCueCommand());
    }
}
