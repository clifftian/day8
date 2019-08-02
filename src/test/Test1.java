package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Date;


public class Test1 {
	public static void main(String[] args) throws Exception  {
		
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date date = formatter.parse("2016-10-31 11:00");
        if (date.compareTo(new java.util.Date()) < 0)
        {
        	//result="OK";
        }else{
        	//result="NOTOK"
        }
		Date dt=new Date();
		
		
		int itest=0;
		while (true){
			
			itest = itest + 1; System.out.println(itest);
			java.lang.Thread.sleep(1000);
			if (itest > 10){
				break;
				
			}
			
		}
		
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