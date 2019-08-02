package com.day8.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HTTPTest {

	/**
	 * @throws InterruptedException                                                                                                                                                      */

	public static void main(String[] args) throws InterruptedException {

		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = new StringBuilder();
		;
		String line = null;
		URL serverAddress = null;

		try {

			serverAddress = new URL("https://www.baidu.com");
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setReadTimeout(10000);
			connection.connect();
			Thread.sleep(60000);
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((line = rd.readLine()) != null) {
				//sb.append(line + "/n");
				System.out.println(line);
			}
			System.out.println(sb.toString());
			rd.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}
}