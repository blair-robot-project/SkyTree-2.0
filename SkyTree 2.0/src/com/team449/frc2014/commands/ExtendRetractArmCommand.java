/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Extends roller arm if true, retracts if false
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class ExtendRetractArmCommand extends CommandBase {
    
    private boolean shouldExtend;
    
    public ExtendRetractArmCommand(boolean shouldExtend) {
        requires(roller);
        this.shouldExtend = shouldExtend;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (shouldExtend)
            roller.setArm(DoubleSolenoid.Value.kForward);
        else
            roller.setArm(DoubleSolenoid.Value.kReverse);
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
