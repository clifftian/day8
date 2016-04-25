package com.day8.rmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

//MyRmiServer.java
public class MyRmiServer {
	public static void main(String args[]) {
		try {
			// ʵ����Զ�̶���ͬʱ�����˸ö���
			MyRmiImpl server = new MyRmiImpl();
			System.out.println("Server: The server instance is :" + server);
			// ��ñ���RMIע������
			Registry registry = LocateRegistry.createRegistry(10991);
			System.out.println("Server: The registry is :" + registry);
			// ��ע����а�Զ�̶���
			registry.bind("ServerJobs", server);
			// ͨ��������׼������
			System.out.println("Server: System already!");
		} catch (RemoteException e) {
			System.out.println("Server: �ڽ���Զ�����ӵ������������ ��" + e.getMessage());
			System.out.println(e.toString());
		} catch (AlreadyBoundException e1) {
			System.out.println("Server: ����ע��� �а�ʱ���������⣬�����ѱ����ˣ�/n" + e1.getMessage());
		}
	}
}