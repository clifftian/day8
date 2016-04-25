package com.day8.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirectoryLister {

	public static void main(String[] args) {

		String dname = args[0];

		File dir = new File(dname);

		FileFilter theFilter = new FileFilter(".*c.*");
		String[] fname = dir.list(theFilter);

		for (String s : fname) {
			System.out.println(s);
		}

	}

}

class FileFilter implements FilenameFilter {

	String fileString;

	public FileFilter(String fil) {
		fileString = fil;
	}

	public boolean accept(File dir, String name) {
		Pattern p = Pattern.compile(fileString);
		return p.matcher(name).matches();
	}

}
