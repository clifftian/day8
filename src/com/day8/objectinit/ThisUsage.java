package com.day8.objectinit;

public class ThisUsage {

	private int ivalue=0;
	public ThisUsage(int ... i){
		ivalue=i[0];
		for (int a : i){
			System.out.println( a);
		}
	}
	
	public ThisUsage increment(int iinc){
		ivalue=ivalue+iinc;
		return this;
	}
	
	public void print(){
		System.out.println( "current value is "+ivalue);
	}
	
	public static void main(String[] args) {

		ThisUsage tu = new ThisUsage(10,20,30,40);
		tu.increment(10).increment(10).increment(10).print();

	}

}
