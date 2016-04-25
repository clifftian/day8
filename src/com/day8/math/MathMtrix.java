package com.day8.math;

public class MathMtrix {

	public static void main(String[] args) {

		int mNumber = 0;
		if (args.length !=1){
			mNumber=9;
		}else{
		mNumber=Integer.parseInt(args[0]);
		}
		
		for (int i=1; i <= mNumber; i++){
			
			for (int j=1; j<=i; j++ ){
				System.out.print(j + "X" + i + "=" + j*i + "  ");
				
			}
			System.out.println();
		}	

	}

}
