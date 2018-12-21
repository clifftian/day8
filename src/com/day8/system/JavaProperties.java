package com.day8.system;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public class JavaProperties {

	/**
	 * get system environment variables and properties
	 * @return	N/A
	 * @param args specific property or environment variable
	 */
	public static void main(String[] args) {

		Map<String, String> penv = System.getenv();
		for ( Map.Entry<String, String> me : penv.entrySet() ){
			//System.out.println(me.getKey() + "=" + me.getValue());
		} 
		Properties p = System.getProperties();
		Enumeration<Object> e = p.elements(); 
		while (e.hasMoreElements()){
			System.out.println(e.nextElement());
		}

	}

}
