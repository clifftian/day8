package com.day8.memory;

import java.util.HashMap;

public class LowMemoryTest {

	public static void main(String[] args) throws InterruptedException {

		String str1 = "abcdefghij";
		for (int j = 0; j < 10; j++) str1 = str1 + str1; //String of 10k
		System.out.println(str1.length());
		HashMap<String, String> hm = new HashMap<String, String>();
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			hm.put(Integer.toString(i), str1+Integer.toString(i));
			System.out.println("Free: " + Runtime.getRuntime().freeMemory() + " Total: "+ Runtime.getRuntime().totalMemory()  + " Max: "+ Runtime.getRuntime().maxMemory());	
			System.out.println(hm.size());
		}
	}
}
