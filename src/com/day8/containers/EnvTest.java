package com.day8.containers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EnvTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<String, String> hm = System.getenv();
		
		for(Map.Entry<String, String> ent : hm.entrySet()){
			System.out.println(ent.getKey() + " = " + ent.getValue());
		}
		
		
		for (Map.Entry entry : System.getenv().entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
		
	}

}
