package com.day8.io;

import java.io.*;
public class RemoteIOTest {
	public static void main(String[] args) throws IOException {
		File srcFile = new File(args[0]);
		File destFile = new File(args[1]);

		FileInputStream in = new FileInputStream(srcFile);
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destFile));
		
		System.out.print("Start writing to file...... ");
		long startTime=System.currentTimeMillis();
		byte[] b = new byte[1024];
		try {
		
				while (in.read(b)!=-1)
				{
					out.write(b);
					
				}
				out.close();
				in.close();			
				System.out.printf("done and the speed is %10.2f s;\n", (float)((System.currentTimeMillis() - startTime)/1000) );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
