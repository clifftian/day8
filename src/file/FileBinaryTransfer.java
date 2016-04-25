package file;

import java.io.*;

public class FileBinaryTransfer {

	public void fileTransfer(String source, String target) throws Exception {

		FileInputStream fis = new FileInputStream (source);
		FileOutputStream fos = new FileOutputStream (target);
		try {			
			byte[] buf = new byte[1024]; 
			
			while (fis.read(buf) != -1){
				fos.write(buf);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			fis.close();
			fos.close();
		}
		

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileBinaryTransfer fbt = new FileBinaryTransfer();
		fbt.fileTransfer("Y:/VMware/Windows 8 Enterprise en x64.zip",
				"F:\\temp\\test.zip");

	}

}
