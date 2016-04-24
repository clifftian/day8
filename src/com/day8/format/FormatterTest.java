package com.day8.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FormatterTest {

	public static void main(String[] args) {
		
		double d1=36666.4567890;
		double d2=3666688.4568887890;
		System.out.printf("%-10.2f -- %33.1f", d1, d2);  System.out.println();
		
		String s1="3.333";
		String s2="4.5";
		System.out.printf("%1$-10.10s -- %1$15.100s", s1, s2);System.out.println();
		
		String dts = "2016-06-01 23:48:17";
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		try {
			System.out.println(df.parse(dts));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(df.format(new Date()));
		
		Date dt = new Date();
		System.out.println(dt);
		

		
		

	}

}
