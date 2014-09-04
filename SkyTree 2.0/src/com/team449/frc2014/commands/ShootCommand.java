/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Eyob
 */
public class ShootCommand extends CommandBase {
    
    private Timer timer = new Timer();
    private boolean shoot;
    private boolean safety;
    private boolean mustUpdate;
    
    public ShootCommand(boolean shoot, boolean safety){
        requires(roller);
        requires(flinger);
        this.shoot = shoot;
        this.safety = safety;
        this.mustUpdate = false;
    }
    
    public ShootCommand() {
        requires(roller);
        requires(flinger);
        this.shoot = controlBoard.getFShoot();
        this.safety = controlBoard.getSafety();
        this.mustUpdate = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        boolean cond = roller.getArm().get().equals(DoubleSolenoid.Value.kForward);
        flinger.setStatus(cond);
        boolean cond2 = false;
        if (cond){
            if (mustUpdate){
                shoot = controlBoard.getFShoot();
                safety = controlBoard.getSafety();
            }
            cond2 = shoot && safety;
        }
        flinger.setFlinger(cond2 && timer.get() < 1000);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
