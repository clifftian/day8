package perf;

import java.util.HashMap;

public class OOMETesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		HashMap<Integer, String> hm = new HashMap();
		String s = null;
		String temp="abcdefghijklmnopqrst|||||abcdefghijklmnopqrst|||||abcdefghijklmnopqrst|||||abcdefghijklmnopqrst||||a";
		
		for (int i=0; i <= 10000; i++)
		{
			s = s + temp;

		}
		System.out.println(s.length());
		Thread.sleep(2000);
		Integer i=0;
		
		while(true){
			s=s+"Q";
			hm.put(i++, s);
			Thread.sleep(10);
			System.out.println("Free: " + Runtime.getRuntime().freeMemory() + " Total: "+ Runtime.getRuntime().totalMemory()  + " Max: "+ Runtime.getRuntime().maxMemory());	
			System.out.println(hm.size());
		}
		
	}

}
