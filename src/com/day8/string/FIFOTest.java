package com.day8.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FIFOTest {

	public void fread() throws IOException{
		
		InputStream fi = FIFOTest.class.getResourceAsStream("FormatTest.class");
		//System.out.println(fi);
		FileOutputStream fos = new FileOutputStream(new File("aaaaa.class"));
		byte[] b = new byte[10];
		int len;
		while((len=fi.read(b)) != -1){
			//System.out.println(b);
			fos.write(b, 0, len);
		}
		fos.close();
		fi.close();
		
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FIFOTest f = new FIFOTest();
		f.fread();
		
	}

}
