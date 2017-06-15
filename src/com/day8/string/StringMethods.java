package com.day8.string;

import java.util.regex.*;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

public class StringMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "AAAAAA BBBBBBB CC";
		String cs = "AAAAAAA BBBBBBB CC";
		float f1= (float) 0.0003;
		double d1=123.44444;
		System.out.format("this is  %30.6fand %f", f1, d1);
		System.out.println();
		System.out.println(str.substring(8));
		//System.out.println(str.compareToIgnoreCase(cs));
		//System.out.println(str.concat("EEE"));
		//System.out.println(str.charAt(0));

	}

}
