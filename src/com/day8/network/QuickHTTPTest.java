package com.day8.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class QuickHTTPTest {

	/**
	 * @throws InterruptedException                                                                                                                                                      */

	public static void main(String[] args) throws InterruptedException {

		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = new StringBuilder();
		String line = null;
		URL serverAddress = null;

		try {

			serverAddress = new URL("http://enux-wnc-102.ptcts.com/Windchill/wt.properties");
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.connect();
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println(sb.toString());
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}
}