package com.day8.rmi;

import java.rmi.*;

//����ӿڱ���̳�Remote �ӿ�
public interface MyRmiInterface extends Remote {
	// �������� ʱ��������ʽ���׳�RemoteException�쳣
	public String serverJobs() throws RemoteException;
}