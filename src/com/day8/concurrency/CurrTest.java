package com.day8.concurrency;

import java.util.PriorityQueue;

public class CurrTest {
	private int queueSize=10;
	private PriorityQueue<Integer> queue=new PriorityQueue<Integer>(queueSize);

	public static void main(String[] args) {
		CurrTest test = new CurrTest();
		Producer producer = test.new Producer();
		Consumer consumer = test.new Consumer();
		consumer.start();
		producer.start();

	}
	class Consumer extends Thread {
		
		public void run(){
			System.out.println("Consumer starts");
			consumer();
		}
		
		public void consumer(){
			while(true){
				synchronized (queue){
					while(queue.size()==0){
						System.out.println("queue was empty");
						try {
							queue.wait();
							//queue.notifyAll();
						} catch (InterruptedException e) {
							e.printStackTrace();
							//queue.notify();
						}
					}
					queue.poll();
					queue.notifyAll();
					System.out.println("one was polled, with remaining of :"+queue.size());
				}
			}
		}
		
	}
	class Producer extends Thread {
		public void run (){
			produce();
		}
		public void produce(){
			System.out.println("Producer strted");
			while(true){
				synchronized (queue) {
					while(queue.size()==queueSize){
						System.out.println("queue was full");
						try {
							
							queue.wait();
							//System.out.println("P wait");
							//queue.notifyAll();
						} catch (InterruptedException e) {
							e.printStackTrace();
							//queue.notify();
						}
					}
				
					queue.offer(1);
					System.out.println("P Notify");
					queue.notifyAll();
					System.out.println("Insert an element, with total :"+queue.size());
				}
			}
		}
	}
	
}
