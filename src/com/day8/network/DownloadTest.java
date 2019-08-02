package com.day8.network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;

public class DownloadTest {

	public static void main(String[] args) throws InterruptedException {

		String wnc_url = "http://pdm.weichai.com/Windchill/wtcore/test/";

		for (int n = 0; n < 30; n++) {
			for (int i = 0; i < args.length; i++) {
				String fname = args[i];
				String checkSumResult = "";
				try {

					URL url = new URL(wnc_url + fname);
					URLConnection conn = url.openConnection();
					InputStream fis = conn.getInputStream();
					FileOutputStream fos = new FileOutputStream(fname);
					MessageDigest complete = MessageDigest.getInstance("MD5");

					byte[] buffer = new byte[1204];
					int byteread = 0;
					while ((byteread = fis.read(buffer)) != -1) {
						fos.write(buffer, 0, byteread);
						complete.update(buffer, 0, byteread);
					}
					fos.close();
					fis.close();

					byte[] b = complete.digest();
					for (int j = 0; j < b.length; j++) {
						checkSumResult += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
					}
					System.out.println("Download of : " + args[i] + " is done, and the checksum is " + checkSumResult);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			Thread.sleep(30000);
		}

	}
}