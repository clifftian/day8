package file;

import java.io.File;

public class FileSize {

	public static void main(String[] args) {
		File f = new File("f:/temp/55247_1.ser");
		System.out.println("The dir size of MB :" + f.getTotalSpace()/1024/1024);

	}

}
