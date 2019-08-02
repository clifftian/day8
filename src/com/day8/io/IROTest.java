package com.day8.io;

import java.io.*;
public class IROTest {
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 86400*2; i++) {
			
			FileOutputStream fos = new FileOutputStream(args[0]);
			try {
				fos.write("IO Test starting!".getBytes());
				Thread.sleep(500);
				fos.write("IO Test done for this file".getBytes());
				System.out.println("Done");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fos.close();
			}
			
		}
	}
}
