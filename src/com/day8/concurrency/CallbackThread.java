package com.day8.concurrency;

interface ResultProcessor{
	
	public void process(int res);
	
}

class DoThread extends Thread{
	
	ResultProcessor rp;
	private int res;
	
	public DoThread(ResultProcessor myrp){
		rp=myrp;
	}
	
	public void run(){
		for (int i = 0; i <= 1000000000; i++) {
			res = res + i;
		}
		
		rp.process(res);
		
	}
	
	
	
}

public class CallbackThread implements ResultProcessor {

	public void process (int res){
		System.out.println(res);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallbackThread rp = new CallbackThread();
		DoThread dth = new DoThread(rp);
		dth.start();
		
	}

}
