/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.commands.auto;

import com.team449.frc2014.commands.CommandBase;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 * Get into a good position before you shoot
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class AdjustPositionCommand extends CommandBase {
    
    private double value;
    
    public AdjustPositionCommand() {
        requires(drive);
    }

    protected void initialize() {
    }

    protected void execute() {
        double value = BigAutoCheckCommand.goodToGo ? 5 : 0;
        try {
            drive.setLeft(value);
            drive.setRight(-value);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    protected boolean isFinished() {
        return BigAutoCheckCommand.done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
