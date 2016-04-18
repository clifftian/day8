package com.day8.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FIrstFile {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(System.getProperty("user.dir"));
		java.io.FileInputStream fio = new java.io.FileInputStream(new java.io.File("ttt"));
		FileOutputStream fos = new FileOutputStream("ooo");
		
		byte[] b = new byte[1000];
		int len=0;
		while((len=fio.read(b,0, b.length)) != -1){
			for (int i=0; i<b.length; i++){
				System.out.print((char)(b[i]));
			}
			fos.write(b,0, len);
		}
		
		fos.close();
		fio.close();

	}

}
