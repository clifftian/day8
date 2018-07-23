package com.day8.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateComparison {
	
	
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		long startTime = System.currentTimeMillis();
		java.util.Date now = new java.util.Date();
		java.util.Date inputdate;
        String input = "2015-03-003 16:30";
        java.text.SimpleDateFormat inputDf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");

        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        Calendar calTemp = (Calendar) cal.clone();
        calTemp.add(Calendar.DAY_OF_YEAR, -5);
        System.out.println("XXX : " + calTemp.getTime());
        
        
		try {
			inputdate = inputDf.parse(input);
			if (now.compareTo(inputdate)>0){
				System.out.println("Cliff: done" );
			}else{
				System.out.println("Cliff: before  " + inputdate + " need run again!");
			}

		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		java.lang.Thread.sleep(1000);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
        
	}

}
