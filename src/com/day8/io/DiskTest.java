package com.day8.io;

import java.io.*;
public class DiskTest {
	public static void main(String[] args) throws IOException {
		String str = String.format("%1024s", "n");
		byte b[] = str.getBytes();
		try {
			while (true)
			{
				long startTime=System.currentTimeMillis();
				
				/*DataOutputStream out = new DataOutputStream(new FileOutputStream(args[0]));
				System.out.print("Start writing to file...... ");
				for (int i=0; i<102400; i++)
					out.writeBytes(str);
				out.close(); */
				
				
				
				FileOutputStream out = new FileOutputStream(args[0]);
				System.out.print("Start writing to file...... ");
				for (int i=0; i<10240000; i++)
					out.write(b);
				System.out.println(b);
				out.close();
				
				
				System.out.printf("done and the speed is %10.2f KB/s;\n", (float)102400/((System.currentTimeMillis() - startTime)/1000) );
				Thread.sleep(100);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
