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
			// �������rmiregistry����������ϵ�ע ���
			Registry registry = LocateRegistry.getRegistry("ftian2d2.ptcnet.ptc.com", 10991);
			System.out.println("Client: returned registry is :" + registry);
			//java.lang.Thread.dumpStack();
			
			// ��ѯ�����Զ�̶���Ĵ��
			MyRmiInterface stub = (MyRmiInterface) registry.lookup("ServerJobs");
			System.out.println("Client: returned stub is :" + stub);
			
			// ����ʹ�ñ��ض��󷽷�����������Զ�̷���
			java.lang.Thread.dumpStack();
			String response = stub.serverJobs();
			System.out.println("Client: response:" + response);
		} catch (Exception e) {
			System.out.println("Client: Client exception :" + e.toString());
			e.printStackTrace();
		}
	}
}