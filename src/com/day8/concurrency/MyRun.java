package com.day8.concurrency;

public class MyRun implements Runnable {

	public int i=0;
	
	public MyRun(int a){
		i=a;
	}
	
	@Override
	public void run() {
		int j = 100;
		while (j > 0) {
			System.out.println("hello" + i);
			j = j - 1;
		}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread m1 = new Thread(new MyRun(1));
		Thread m2 = new Thread(new MyRun(2));
		m1.start();
		m2.start();
		
	}

}
