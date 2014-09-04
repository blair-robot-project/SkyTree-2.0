package com.team449.frc2014.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Command to move the front panel
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class FrontPanelCommand extends CommandBase {
    
    private boolean shouldOpen;
    
    public FrontPanelCommand(boolean shouldOpen) {
        requires(catcher);
        this.shouldOpen = shouldOpen;
    }

    protected void initialize() {
        if(shouldOpen)
            catcher.setFirst(DoubleSolenoid.Value.kForward);
        else
            catcher.setFirst(DoubleSolenoid.Value.kReverse);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
