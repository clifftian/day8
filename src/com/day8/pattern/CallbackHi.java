package com.day8.pattern;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

//http://www.zhihu.com/question/19801131
//Good explanation

class MyFilenameFilter implements FilenameFilter{
	String theFilter;
	public MyFilenameFilter(String str){
		theFilter=str;
	}

	public boolean accept(File arg0, String fname) {
		Pattern p = Pattern.compile(theFilter);
		return p.matcher(fname).matches();
	}
	
}

public class CallbackHi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File f = new File("/home/ftian/workspace/day8/src/com/day8/containers");
		
		FilenameFilter fnf = new MyFilenameFilter(".*Test.*");
		String[] fs = f.list(fnf);
		for (String fname : fs)
			System.out.println(fname);

	}

}
