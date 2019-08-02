package com.day8.math;

public class IntStringInteger {

	public static void main(String[] args) {
		
		
		//int --> String or binrary or octal
		int i=1024;
		
		if (i>0){
			System.out.println(">>>0");
		}else if (i>10){
			System.out.println(">>>10");
		}
		
		System.out.println(String.valueOf(i));
		System.out.println(String.format("%o", i));
		
		Integer i2 = new Integer("128");
		System.out.println(i2.intValue());
		System.out.println(i2.toBinaryString(i2));
		
		//String --> int
		String str="1024";
		System.out.println(Integer.parseInt(str));
		System.out.println(Integer.valueOf(str).intValue());
		
		//Integer <--> int
		System.out.println(i2.intValue());
		Integer wrapperi = i;  //since java 1.5

	}

}
