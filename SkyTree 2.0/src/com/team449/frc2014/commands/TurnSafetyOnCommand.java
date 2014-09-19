/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.commands;

import com.team449.frc2014.OI;

/**
 *
 * @author Eyob
 */
public class TurnSafetyOnCommand extends CommandBase {
    
    public TurnSafetyOnCommand() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        OI.safety = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Run indefinitely until command is explicitly canceled
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        OI.safety = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
