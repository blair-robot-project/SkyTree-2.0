package com.team449.frc2014.commands.auto;

import com.team449.frc2014.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 * I'm sorry. This is the big loopy messy check that flinger and drive depend on
 * So I just made it an actual command. May want to move to util package, though.
 * Better yet, it should be moved to the "autonomous periodic" method.
 * Class just pretends to be an non-abstract Command
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public class BigAutoCheckCommand extends CommandBase {
    
    private double initLeftDist;
    private Timer timer = new Timer();
    public static boolean goodToGo;
    public static boolean done;
    
    public BigAutoCheckCommand() {
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initLeftDist = drive.getLeftDist();
        timer.start();
        goodToGo = false;
        done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double leftDist = drive.getLeftDist();
        // if(Math.abs(leftDist-initLeftDist-14.25) > 0.25 && leftDist-initLeftDist-14.25 < 0) <-- redundant
        if (timer.get() < 4500)
            if (leftDist-initLeftDist < 14)    // removed redundancy
                goodToGo = true;
            else
                goodToGo = false;
        else 
            done = true;    // pointless to put "goodToGo = false" here
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
