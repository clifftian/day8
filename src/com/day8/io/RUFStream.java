package com.day8.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class RUFStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream is = new FileInputStream("F:\\bsci\\666666666\\RUF\\ReferencedFiles");
		DataInputStream allDBFilesDIS = new DataInputStream(is);
		
		File file = new File ("F:\\bsci\\666666666\\RUF\\ReferencedFiles_o.txt");
		PrintWriter pw = new PrintWriter(file);
		
		while (allDBFilesDIS.available() > 0) {
		//System.out.println(allDBFilesDIS.readLong());
		pw.println(allDBFilesDIS.readLong());
		}
		is.close();
		pw.close();

	}

}
