package com.day8.inner;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;


public class InnerClassDirList {
	
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
	
	public void directoryList (String dir) {
		
		File f = new File(dir);
		
		FilenameFilter fnf = new MyFilenameFilter(".*");
		String[] fs = f.list(fnf);
		for (String fname : fs)
			System.out.println(fname);

	}
	
	public static void main(String[] args) {
		
		InnerClassDirList icd = new InnerClassDirList();
		icd.directoryList(".");

	}

}
