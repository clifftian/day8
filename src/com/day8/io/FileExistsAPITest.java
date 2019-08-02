package com.day8.io;
import java.io.*;
import java.util.Calendar;
import java.util.Date;


public class FileExistsAPITest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		File f1 = new File("f:/temp/perftables.gz"); 
		Calendar cal2 = Calendar.getInstance(); 
		if ( (cal2.getTimeInMillis() - f1.lastModified()) > 24*60*60*1000*7 )
		{
			System.out.println("wrong!"+ (cal2.getTimeInMillis() - f1.lastModified()));
		}
		
		System.out.println(new Date(f1.lastModified()));
		Date d1 = new Date(f1.lastModified());
		
		
		//(cal2.add(Calendar.DAY_OF_YEAR, -7)).compareTo(d1);
		
		File f = new File("F:/temp/Cust");
		
		Long startTime = System.currentTimeMillis();
		for (int i=0; i<1; i++){
			f.exists();
			Thread.dumpStack();
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("Run 100 times with total time(seconds) " + (endTime-startTime)/1000);

	}

}
