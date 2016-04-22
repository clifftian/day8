package com.day8.rmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

//MyRmiServer.java
public class MyRmiServer {
	public static void main(String args[]) {
		try {
			// 实例化远程对象，同时导出了该对象
			MyRmiImpl server = new MyRmiImpl();
			System.out.println("Server: The server instance is :" + server);
			// 获得本地RMI注册表对象
			Registry registry = LocateRegistry.createRegistry(10991);
			System.out.println("Server: The registry is :" + registry);
			// 在注册表中绑定远程对象
			registry.bind("ServerJobs", server);
			// 通告服务端已准备好了
			System.out.println("Server: System already!");
		} catch (RemoteException e) {
			System.out.println("Server: 在建立远程连接的情况出现了异 常" + e.getMessage());
			System.out.println(e.toString());
		} catch (AlreadyBoundException e1) {
			System.out.println("Server: 在向注册表 中绑定时出现了问题，名字已被绑定了！/n" + e1.getMessage());
		}
	}
}