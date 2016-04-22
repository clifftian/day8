package com.day8.io;
import java.io.*;


public class FileExistsAPITest {

	public static void main(String[] args) throws ClassNotFoundException {
		

		
		File f = new File("F:/temp/wpsyncqueue2.dts");
		
		Long startTime = System.currentTimeMillis();
		for (int i=0; i<10000; i++){
			f.exists();
			Thread.dumpStack();
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("Run 100 times with total time(seconds) " + (endTime-startTime)/1000);

	}

}
