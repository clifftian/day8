package com.day8.lang;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MSStart {
 
    public static void main(String args[]){
        
    	String str=args[0];
    	List<String> cmds= new ArrayList( Arrays.asList(str.split(" ")) );
        ProcessBuilder pb = new ProcessBuilder(cmds);
    	pb.redirectError();
    	pb.redirectOutput();
        try {
        	System.out.println(pb.command());
        	pb.start();
            System.out.println(pb.toString());
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

