package com.day8.rmi;

import java.rmi.*;
import java.rmi.server.*;
//�����̳� UnicastRemoteObject�ǳ���Ҫ
//MyRmiImpl.java

public class MyRmiImpl extends UnicastRemoteObject implements MyRmiInterface {
	// ��ʵ���������ʱ���͵�����Զ�̶��󣬸ù��췽������
	public MyRmiImpl() throws RemoteException {
		super();
	}

	// ʵ�ֽӿ��еķ��������ʱ�䲻��Ҫ�� ʽ�׳�RemoteException�쳣��
	public String serverJobs() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Server: thread dump :" ); java.lang.Thread.dumpStack();
		return "Server: This is returned from Server";
	}
}