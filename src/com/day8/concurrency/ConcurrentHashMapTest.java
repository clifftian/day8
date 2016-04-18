package com.day8.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest extends Thread {

	public static ConcurrentHashMap<Integer, String> hm = new ConcurrentHashMap<Integer, String>();
	public Object lock = new Object();
	int ii;
	
	ConcurrentHashMapTest(int num){
		ii=num;
	}
	
	void putMap()
	{
		for (int i=ii; i<ii+10; i++){
			System.out.println(Integer.valueOf(i)+" : " + "TT"+i);
			
			hm.put(Integer.valueOf(i), "TT"+i);
			}
	}
	
	public void run(){
		 putMap();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int j=0; j<10; j++)
		{
			new ConcurrentHashMapTest(j*10).start();
		} 
		
		/*
		Iterator  is = SyncHashMap.hm.entrySet().iterator();
		while (is.hasNext()){
			Map.Entry entry = (Map.Entry) is.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}*/
		
		
	}

}
