package com.team449.lib.util;

import com.sun.squawk.microedition.io.FileConnection;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.io.Connector;

/**
 * (Really hate this method of defining constants and honestly don't know
 * why team 254 did this, but...they've used java longer...
 * But seriously...HashTables exist...)
 * Manages constants used in robot code (i.e. solenoid ports)
 * @author Eyob Tsegaye (tse.eyob@gmail.com)
 */

public abstract class ConstantsBase {
    
    private static final Vector constants = new Vector();
    private static final String FILE_PATH = "Constants.txt";
    
    public static void resetConstants(){
        DataInputStream inStream;
        FileConnection fc;
        byte[] buffer = new byte[255];
        String content = "";
        
        try {
            // Initial data extraction into a giant horrifying String
            fc = (FileConnection)Connector.open("file:///" + FILE_PATH,
                    Connector.READ);
            inStream = fc.openDataInputStream();
            while (inStream.read(buffer) != -1)
                content += new String(buffer);
            inStream.close();
            fc.close();
            
            // Parse String into somewhat prettier data
            String[] lines = Util.split(content, "\n");
            for (int i = 0; i < lines.length; i++){
                
                // Data extraction (losing my motivation here)
                String[] line = Util.split(lines[i], "=");
                if (line.length != 2){
                    System.err.println("\"Error: invalid constants file line: \" +\n" +
"                            (lines[i].length() == 0 ? \"(empty line)\" : lines[i]));");
                    continue;
                }
                
                boolean found = false;
                for (int j = 0; j < constants.size(); j++){
                    Constant constant = (Constant)constants.elementAt(j);
                    if (constant.getName().equals(line[0])){
                        System.out.println("Setting " + constant.getName() + " to " + line[1]);
                        constant.setValue(Double.parseDouble(line[1]));
                        found = true;
                        break;
                    }
                }
                if (!found)
                    System.err.println("Error: the constant does not exist: "+lines[i]);
            }
        }
        catch (IOException e){
            System.err.println("Constants.txt not found! Not overriding constants!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static class Constant {
        
        private String name;
        private double value;
        
        public Constant(String consName, double consValue){
            name = consName;
            value = consValue;
            constants.addElement(this);
        }
        
        public String getName(){
            return name;
        }
        
        public double getDouble(){
            return value;
        }
        
        public int getInt(){
            return (int)value;
        }
        
        public void setValue(double newVal){
            value = newVal;
        }
        
        public String toString(){
            return name + " : " + value;
        }
        
    }
    
}
