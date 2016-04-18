package com.day8.concurrency;

class MyThread extends Thread {

	public MyThread(String name) {
		super.setName(name);
	}

	public void run() {

		Integer[] a = new Integer[10];
		for (int i = 0; i < 10; i++) {
			a[i] = new Integer(i);
		}

		for (Integer b : a) {
			System.out.println(this + " : " + b.intValue());
		}

	}

}


class MyRunnable implements Runnable {

	public void run() {

		Integer[] a = new Integer[10];
		for (int i = 0; i < 10; i++) {
			a[i] = new Integer(i);
		}

		for (Integer b : a) {
			System.out.println(this + " : " + b.intValue());
		}

	}

}


public class MyThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	for (int i = 0; i < 5; i++) {
		Thread trd = new Thread(new MyRunnable());
		trd.start();
	}
		
		/*for (int i = 0; i < 5; i++) {
			Thread trd = new MyThread("" + i);
			trd.start();
		} */

	}

}
