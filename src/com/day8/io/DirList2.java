package com.day8.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

public class DirList2 {

	public static FilenameFilter filter (final String regex){
		
		return new FilenameFilter() {
			private Pattern pattern=Pattern.compile(regex);
			
			public boolean accpet(File dir, String name){
			return pattern.matcher(name).matches();
			}

			@Override
			public boolean accept(File arg0, String arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
	}

	public static void main(String[] args) {

		File f = new File(".");
		String list[];

		System.out.println("start");
		if (args.length == 0) {
			list = f.list();
		} else {
			list = f.list(filter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

		for (String fname : list) {
			System.out.println(fname);
		}

	}

}
