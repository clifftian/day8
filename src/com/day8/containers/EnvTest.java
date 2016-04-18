package com.day8.containers;

import java.util.Map;

public class EnvTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (Map.Entry entry : System.getenv().entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
		
	}

}
