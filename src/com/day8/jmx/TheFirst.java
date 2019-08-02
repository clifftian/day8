package com.day8.jmx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeData;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class TheFirst {

	public static void main(String[] args) throws Exception {


		JMXConnector c = JMXConnectorFactory.connect(createConnectionURL());
		Object o = c.getMBeanServerConnection().getAttribute(new ObjectName("java.lang:type=Memory"), "HeapMemoryUsage");
		CompositeData cd = (CompositeData) o;
		System.out.println(cd.get("committed"));
		
		System.out.println("AvailableProcessors :" + c.getMBeanServerConnection().getAttribute(new ObjectName("java.lang:type=OperatingSystem"), "AvailableProcessors"));
	
		final MBeanServerConnection  mbeanServer = c.getMBeanServerConnection();
		final ObjectName  methodServerMBeanName = new ObjectName( "com.ptc:wt.processGroup=MethodServers,methodServer=MethodServer.7189");
		final MethodServerMProxyMBean  methodServersMBeanProxy =MBeanServerInvocationHandler.newProxyInstance( mbeanServer, methodServerMProxyMBeanName, MethodServerMProxyMBean.class, false );
		
	}
	


	private static JMXServiceURL createConnectionURL() throws MalformedURLException
	{
	    //return new JMXServiceURL("rmi", "", 0, "/jndi/rmi://" + host + ":" + port + "/jmxrmi");
		return new JMXServiceURL("service:jmx:rmi://enux-wnc-11.ptcts.com:6049/jndi/rmi://enux-wnc-11.ptcts.com:6049/jmxrmi");
	    
	}

}

