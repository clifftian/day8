package com.day8.concurrency;

class AddThread extends Thread {

	private boolean hasDone = false;
	private Object thelock;
	private int res;

	public AddThread(Object lock) {
		thelock = lock;
	}

	public boolean getStatus() {
		return hasDone;
	}

	public void run() {
		for (int i = 0; i <= 1000000000; i++) {
			res = res + i;
		}

		synchronized (thelock) {
			hasDone = true;
			thelock.notifyAll();
		}

	}

	public int getResult() {
		return res;
	}

}

public class WaitNotifyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object mylock = new Object();
		AddThread myThread = new AddThread(mylock);
		myThread.start();

		while (!myThread.getStatus()) {
			System.out.println("DDDD");

			synchronized (mylock) {
				try {
					mylock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
		System.out.println(myThread.getResult());

	}

}
