package com.day8.system;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public class JavaProperties {
	
	/**
	 * get All or Specific system environment variables
	 * @return	N/A
	 * @param env1 "get the value of specific env"
	 */
	public void sysEnv(String env1)
	{
		Map<String, String> penv = System.getenv();
		if (env1 != null || !env1.isEmpty()) 
		{
			System.out.println(penv.get(env1));
			return;
		}
		for ( Map.Entry<String, String> me : penv.entrySet() ){
			System.out.println(me.getKey() + "=" + me.getValue());
		} 
	}
	
	/**
	 * get All or Specific system properties
	 * @return	no return
	 * @param prop get the value of specific prop
	 */
	public void sysProp(String prop)
	{
		Properties p = System.getProperties();
		if (prop != null || !prop.isEmpty()) 
		{
			System.out.println(p.getProperty(prop));
			return;
		}
		Enumeration<Object> e = p.elements(); 
		while (e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
		//p.list(System.out);
	}

	/**
	 * get system environment variables and properties
	 * @return	N/A
	 * @param args specific property or environment variable
	 */
	public static void main(String[] args) {

		System.out.println(args[0]);
		JavaProperties jp=new JavaProperties();
		jp.sysEnv(args[0]);
		jp.sysProp(args[0]);
		
	}

}
