package com.day8.rmi;

import java.rmi.*;
import java.rmi.registry.*;

//MyRmiClient.java
public class MyRmiClient {
	
	public MyRmiClient() {
	}

	public static void main(String args[]) {
		String host = (args.length < 1) ? null : args[0];
		try {
			// 获得运行rmiregistry服务的主机上的注 册表
			Registry registry = LocateRegistry.getRegistry("ftian2d2.ptcnet.ptc.com", 10991);
			System.out.println("Client: returned registry is :" + registry);
			//java.lang.Thread.dumpStack();
			
			// 查询并获得远程对象的存根
			MyRmiInterface stub = (MyRmiInterface) registry.lookup("ServerJobs");
			System.out.println("Client: returned stub is :" + stub);
			
			// 像在使用本地对象方法那样，调用远程方法
			java.lang.Thread.dumpStack();
			String response = stub.serverJobs();
			System.out.println("Client: response:" + response);
		} catch (Exception e) {
			System.out.println("Client: Client exception :" + e.toString());
			e.printStackTrace();
		}
	}
}