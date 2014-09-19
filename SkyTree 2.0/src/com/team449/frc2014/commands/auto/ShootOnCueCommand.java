package com.team449.frc2014.commands.auto;

import com.team449.frc2014.commands.CommandBase;
import com.team449.frc2014.commands.ShootCommand;
import edu.wpi.first.wpilibj.Timer;

/**
 * Shoot when you can
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class ShootOnCueCommand extends CommandBase {
    
    private Timer timer = new Timer();
    private boolean lastGTG;    // stands for "good to go"
    private boolean lastGTG2;
    
    public ShootOnCueCommand() {
        
    }

    protected void initialize() {
        timer.start();
        lastGTG = false;
        lastGTG2 = false;
    }

    protected void execute() {
        boolean gtg = BigAutoCheckCommand.goodToGo;
        boolean gtg2 = lastGTG && !gtg && timer.get() < 500;
        boolean shoot = lastGTG2 && !gtg2;
        if (shoot) (new ShootCommand(true)).start();
        lastGTG = gtg;
        lastGTG2 = gtg2;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return BigAutoCheckCommand.done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
