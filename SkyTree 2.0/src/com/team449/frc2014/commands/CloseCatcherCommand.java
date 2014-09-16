/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 * @author Eyob
 */
public class CloseCatcherCommand extends CommandBase {
    
    public CloseCatcherCommand() {
        requires(catcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        catcher.set(DoubleSolenoid.Value.kReverse, false, true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
