package com.day8.concurrency;

public class TestWaitNotify {

	public static Object object = new Object();

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();

		thread1.start();
		thread2.start();
	}

	static class Thread1 extends Thread {
		@Override
		public void run() {
			synchronized (object) {
				try {
					object.wait();
					java.lang.Thread.sleep(10000);
				} catch (InterruptedException e) {
				}
				System.out.println("线程" + Thread.currentThread().getName()
						+ "获取到了锁");
			}
		}
	}

	static class Thread2 extends Thread {
		@Override
		public void run() {

			try {

				synchronized (object) {
					object.notify();
					System.out.println("线程" + Thread.currentThread().getName()
							+ "调用了object.notify()");
				}
				System.out.println("线程" + Thread.currentThread().getName()
						+ "释放了锁");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}