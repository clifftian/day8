package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;


public class Test1 {
	public static void main(String[] args) throws Exception  {
		
		File f = new File("f:/temp/ptc-tools.txt");
		
		BufferedReader fr = new BufferedReader (new FileReader(f));
		
		String str;
		while((str=fr.readLine()) != null){
			System.out.println(str);
		}
		
		/*char[] cbuf = new char[1024] ;
		while(fr.read(cbuf) !=-1){	
			System.out.print(cbuf);
		} */
		
	}

}