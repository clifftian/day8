package com.day8.concurrency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SyncHashMap extends Thread {

	public static HashMap<Integer, String> hm = new HashMap();
	public Object lock = new Object();
	int ii;
	
	SyncHashMap(int num){
		ii=num;
	}
	
	void putMap()
	{
		//synchronized (lock) {
		for (int i=ii; i<ii+10; i++){
			//System.out.println(Integer.valueOf(i)+" : " + "TT"+i);
			
			hm.put(Integer.valueOf(i), "TT"+i);
			}
		//}
	}
	
	public void run(){
		 putMap();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int j=0; j<1000; j++)
		{
			new SyncHashMap(j*10).start();
		} 
		
		/*
		Iterator  is = SyncHashMap.hm.entrySet().iterator();
		while (is.hasNext()){
			Map.Entry entry = (Map.Entry) is.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}*/
		
		
	}

}
