package com.day8.rmi;

import java.rmi.*;

//这个接口必需继承Remote 接口
public interface MyRmiInterface extends Remote {
	// 声明方法 时，必需显式地抛出RemoteException异常
	public String serverJobs() throws RemoteException;
}