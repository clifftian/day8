package file;

import java.io.*;

public class FileBinaryTransfer {

	public void fileTransfer(String source, String target) throws Exception {


		FileInputStream fi = new FileInputStream(source);
		FileOutputStream fo = new FileOutputStream(target);
		try {
			byte[] buff = new byte[100];
			int len = 100;

			while ((len = fi.read(buff)) != -1) {
				System.out.println(buff.toString());
				fo.write(buff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fi.close();
			fo.close();
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileBinaryTransfer fbt = new FileBinaryTransfer();
		fbt.fileTransfer("F:\\temp\\BinaryTransfer.zip",
				"F:\\temp\\BinaryTransfer_1.zip");

	}

}
