/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.team449.lib.util;

import com.team449.frc2014.Constants;
import java.util.Vector;

/**
 * Yeah, so FIRST took away some really useful methods, so this is partly to
 * keep them there. Also, there's stuff we need like deadBand
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */
public final class Util {
    
    /**
     * Method was just plain copied. I'm sorry...
     */
    public static String[] split(String input, String delimiter) {
        Vector node = new Vector();
        int index = input.indexOf(delimiter);
        while (index >= 0) {
            node.addElement(input.substring(0, index));
            input = input.substring(index + delimiter.length());
            index = input.indexOf(delimiter);
        }
        node.addElement(input);
        
        String[] retString = new String[node.size()];
        for (int i = 0; i < node.size(); ++i) {
            retString[i] = (String) node.elementAt(i);
        }
        
        return retString;
    }
    
    public static double deadBand(double input){
        return Math.abs(input) < Constants.joyDeadBand.getDouble() ? 0 : input;
    }
    
}
