package jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import oracle.sql.BLOB;

public class BlobAccess {

	private Connection getConnection() throws Exception {

		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Properties pro = new Properties();
		pro.load(new FileReader("bin/jdbc/config.properties"));
		String host = pro.getProperty("host");
		String database = pro.getProperty("database");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		String port = pro.getProperty("port");
		String url = "jdbc:oracle:thin:@" + host + ":" + port +":" + database;
		System.out.println("Connecting to Oracle via :" + url);
		return DriverManager.getConnection(url, username, password);

	}

	public boolean read(String[] sqlWhere, String fileName) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		BLOB blob = null;
		boolean flag = false;
		try {
			conn = getConnection();
			System.out.println("Connected to Oracle!");
			String sql = "select lobloc, streamid, classnamea2a2 from streamdata where streamid=? and classnamea2a2=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(sqlWhere[0]));
			ps.setString(2, sqlWhere[1]);
			rs = ps.executeQuery();
			if(rs.next()) {
				blob = (BLOB) rs.getBlob(1);
			}
			InputStream in = blob.getBinaryStream();
			byte[] buf = new byte[1024];
			int bytesIn = 0;
			FileOutputStream out = new FileOutputStream(fileName);
			while ((bytesIn = in.read(buf, 0, 1024)) != -1) {
				out.write(buf, 0, bytesIn);
			}
			in.close();
			out.close();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		BlobAccess bu = new BlobAccess();
		
		//System.out.println(Integer.parseInt("864000000"));
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(bu.write("CB", "001", "image1", "F:\\temp\\154"));
		System.out.println(bu.read(new String[]{"154","wt.content.StreamData"}, "F:\\temp\\154"));
	}


	public boolean write(String projectId, String taskId, String fileName, String file) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		BLOB blob = null;
		boolean flag = false;
		try {
			conn = getConnection();
			System.out.println("Connected to Oracle!");
			conn.setAutoCommit(false);

			String sql = "INSERT INTO PS_ZP_PRJ_WBS_BLOB BLB(ZP_PRJ_ID, ZZ_SEQ_NUM, ZZ_FILE_NAME, ZZ_IMAGE_BLOB) VALUES(?, ? ,? ,empty_blob())";
			ps = conn.prepareStatement(sql);
			ps.setString(1, projectId);
			ps.setString(2, taskId);
			ps.setString(3, fileName);
			ps.executeUpdate();
			sql = "SELECT ZZ_IMAGE_BLOB FROM PS_ZP_PRJ_WBS_BLOB WHERE ZP_PRJ_ID = ? AND ZZ_SEQ_NUM = ? AND ZZ_FILE_NAME = ? FOR UPDATE";
			ps = conn.prepareStatement(sql);
			ps.setString(1, projectId);
			ps.setString(2, taskId);
			ps.setString(3, fileName);
			rs = ps.executeQuery();
			if(rs.next()) {
				blob = (BLOB) rs.getBlob(1);
			}
			InputStream in = new FileInputStream(file);
			OutputStream out = blob.setBinaryStream(1L);
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = in.read(buffer)) != -1){
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
			conn.commit();
			conn.setAutoCommit(true);
			flag = true; 
		}
		catch(Exception e) {
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

}