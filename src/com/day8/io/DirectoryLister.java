package com.day8.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Pattern;

public class DirectoryLister {

	public static void main(String[] args) {

		File f = new File(".");
		String list[];
		
		System.out.println("start");
		if (args.length==0){
			list = f.list();
		}else {
			list = f.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		
		for(String fname : list){
			System.out.println(fname);
		}
		Properties props = System.getProperties();
		for (Object kname : props.keySet()){
			System.out.println(kname + " = " + props.get(kname));
		}

	}

}

class DirFilter implements FilenameFilter {
	
	private Pattern pattern;
	
	public DirFilter(String regex){
		pattern=Pattern.compile(regex);		
	}
	
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}
