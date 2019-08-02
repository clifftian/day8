package jmx.MXBean;

import java.util.List;
import java.util.Map;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.QueryExp;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import wt.manager.jmx.MethodServerMProxyMBean;

/*
1. Refer to bottom for the output
2. Refer to bottom for the Map Structure of methodServerResults
3. Can execute inside Windchill JVM, or out of Windchill JVM (this need <codebase> in ClassPath)
*/

public class WNCMBeanTest {

	public static void main(String[] args) throws Exception {

		MBeanServerConnection mbeanServer = getSMMBeanServer();
		ObjectName methodServerMProxyMBeanName = new ObjectName("com.ptc:wt.processGroup=MethodServers");
		ObjectName dumperMBeanName = new ObjectName("com.ptc:wt.subsystem=Dumper");
		ObjectName runtimeMBeanName = new ObjectName("java.lang:type=Runtime");
		ObjectName osMBeanName = new ObjectName("java.lang:type=OperatingSystem");
		MethodServerMProxyMBean methodServersMBeanProxy = MBeanServerInvocationHandler.newProxyInstance(mbeanServer, methodServerMProxyMBeanName, MethodServerMProxyMBean.class, false);
		String getAttributesSignature[] = { ObjectName[].class.getName(), QueryExp[].class.getName(), String[][].class.getName() };
		Object serverManagerGetAttrsArgs[] = { new ObjectName[] { runtimeMBeanName, osMBeanName }, null, new String[][] { new String[] { "StartTime", "InputArguments" }, new String[] { "TotalPhysicalMemorySize", "AvailableProcessors" } } };
		Object methodServrGetAttrsArgs[] = { new ObjectName[] { runtimeMBeanName }, null, new String[][] { new String[] { "StartTime", "InputArguments" } } };

		Map<String, Object> serverManagerResults = (Map) methodServersMBeanProxy.invokeInfoOpInAllServerManagers(dumperMBeanName, "getAttributes", serverManagerGetAttrsArgs, getAttributesSignature);
		Map<String, Object> methodServerResults = (Map) methodServersMBeanProxy.invokeInfoOpInAllClusterMethodServers(dumperMBeanName, "getAttributes", methodServrGetAttrsArgs, getAttributesSignature);
		String smName = null;

		// Get SMs information
		for (Map.Entry<String, Object> e : serverManagerResults.entrySet()) {
			System.out.println("@@@@@@ The SM1: " + e.getKey());
			smName = e.getKey();
			Map[] smResult = (Map[]) (e.getValue()); // Map[]
														// Map.Entry<ObjectName,
														// AttributeList>[]
			for (Map<ObjectName, AttributeList> mbeanAttrMap : smResult) {
				for (Map.Entry<ObjectName, AttributeList> mbeanAttrMapEntry : mbeanAttrMap.entrySet()) {
					System.out.println("   The MBean is : " + mbeanAttrMapEntry.getKey());
					List<Attribute> attrList = mbeanAttrMapEntry.getValue().asList();
					for (Attribute sm : attrList) {
						Object v = sm.getValue();
						String attr = "";
						if (v instanceof String[]) // The InputArguments is
													// String[]
						{
							for (String s : (String[]) v)
								attr = attr + s;
							System.out.println("      Attribute Name : " + sm.getName() + " || Value : " + attr);
						} else {
							System.out.println("      Attribute Name : " + sm.getName() + " || Value : " + v);
						}

					}
				}
			}
		}

		// Get MS information
		for (Map.Entry<String, Object> e : methodServerResults.entrySet()) {
			System.out.println("@@@@@@ : " + e.getKey() + "   :  ");
			Map<String, Object> msResult = (Map<String, Object>) (e.getValue());
			for (Map.Entry<String, Object> mbeanAttrMap : msResult.entrySet()) {
				System.out.println("   @@@" + mbeanAttrMap.getKey());
				Map<ObjectName, AttributeList>[] m = (Map<ObjectName, AttributeList>[]) (mbeanAttrMap.getValue());
				for (Map<ObjectName, AttributeList> mbeanAttrMapEntry : m) {
					for (Map.Entry<ObjectName, AttributeList> mbeanAttrMapEntry1 : mbeanAttrMapEntry.entrySet()) {
						System.out.println("      @@@ The MBean is : " + mbeanAttrMapEntry1.getKey());
						List<Attribute> attrList = mbeanAttrMapEntry1.getValue().asList();
						for (Attribute ms : attrList) {
							Object v = ms.getValue();
							String attr = "";
							if (v instanceof String[]) // The InputArguments is String[]
							{
								for (String s : (String[]) v)
									attr = attr + s;
								System.out.println("      Attribute Name : " + ms.getName() + " || Value : " + attr);
							} else {
								System.out.println("      Attribute Name : " + ms.getName() + " || Value : " + v);
							}
						}
					}

				}
			}

		}
	}

	private static MBeanServerConnection getSMMBeanServer() throws Exception {
		// If execute in MS/BGMS JVM, can get below directly
		JMXServiceURL smJMXUrl = new JMXServiceURL("service:jmx:rmi://enux-wnc-11.ptcts.com:6049/jndi/rmi://enux-wnc-11.ptcts.com:6049/jmxrmi");
		JMXConnector c = JMXConnectorFactory.connect(smJMXUrl);
		return c.getMBeanServerConnection();
	}

}

// The Output
/*
SM1 host-/
	|RAM:			java.lang:type=OperatingSystem > TotalPhysicalMemorySize & AvailableProcessors
	|JVM options:	java.lang:type=Runtime >  StartTime & InputArguments
SM1 host-/
	|RAM:			java.lang:type=OperatingSystem > TotalPhysicalMemorySize & AvailableProcessors
	|JVM options:	java.lang:type=Runtime >  StartTime & InputArguments
...	
SM1-/
	MS1-/
		|java.lang:type=Runtime >  InputArguments & StartTime
	MS2-/
		|java.lang:type=Runtime >  InputArguments & StartTime
	BGMS1-/
		|java.lang:type=Runtime >  InputArguments & StartTime	
...
*/

//The Map<String, Object> methodServerResults Structure
/*
{
"SM1 name e.g.3884@en2k8" : {
										"MS1 Name e.g.MS.4040" : {
																	"MBean1 e.g. java.lang:type=Runtime" : {
																											"Attribute2, e.g. InputArguments" : Value,
																											"Attribute2, e.g. InputArguments" : Value,
																											}
																	"MBean2 e.g. ava.lang:type=OperatingSystem" : {
																											"Attribute2, e.g. InputArguments" : Value,
																											"Attribute2, e.g. InputArguments" : Value,
																											}
																	...
																	}
										"MS1 Name e.g.BGMS.4032" : {
																	"MBean1 e.g. java.lang:type=Runtime" : {
																											"Attribute2, e.g. InputArguments" : Value,
																											"Attribute2, e.g. InputArguments" : Value,
																											}
																	"MBean2 e.g. ava.lang:type=OperatingSystem" : {
																											"Attribute2, e.g. InputArguments" : Value,
																											"Attribute2, e.g. InputArguments" : Value,
																											}
																		...
																		}
								}
"SM1 name e.g.XXXXXXXXXXXXX" : {
										"MS1 Name e.g.MS.4040" : {
																	"MBean1 e.g. java.lang:type=Runtime" : {
																											"Attribute2, e.g. InputArguments" : Value,
																											"Attribute2, e.g. InputArguments" : Value,
																											}
																	"MBean2 e.g. ava.lang:type=OperatingSystem" : {
																											"Attribute2, e.g. InputArguments" : Value,
																											"Attribute2, e.g. InputArguments" : Value,
																											}
																	...
																	}
										"MS1 Name e.g.BGMS.4032" : {
																	"MBean1 e.g. java.lang:type=Runtime" : {
																											"Attribute2, e.g. InputArguments" : Value,
																											"Attribute2, e.g. InputArguments" : Value,
																											}
																	"MBean2 e.g. ava.lang:type=OperatingSystem" : {
																											"Attribute2, e.g. InputArguments" : Value,
																											"Attribute2, e.g. InputArguments" : Value,
																											}
																		...
																		}
								}
...
*/
