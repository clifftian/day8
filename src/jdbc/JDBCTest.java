package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

//usage:
//java jdbc.JDBCTest enux-wnc-102.ptcts.com 1521 wind guest ts
//Purpose:
//Connect to Oracle and run SQL select count(*) from administrativedomain\
//Loop 100 times with 10 seconds interval

public class JDBCTest {

	public static void main(String[] args) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;

		for (int i = 0; i < 100; i++) {

			try {

				DriverManager
						.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Long dt1 = System.currentTimeMillis();
				String connStr = "jdbc:oracle:thin:@" + args[0] + ":" + args[1]
						+ ":" + args[2];
				System.out.println("Connection String : " + connStr);
				conn = DriverManager.getConnection(connStr, args[3], args[4]);
				Long dt2 = System.currentTimeMillis();
				System.out
						.println("DB connection build time in milliseconds: "
								+ (dt2 - dt1));

				String insertStmt = "select count(*) from administrativedomain";
				pstmt = conn.prepareStatement(insertStmt);

				// pstmt.setString(1, "AAA");
				Long dt3 = System.currentTimeMillis();
				pstmt.execute();
				Long dt4 = System.currentTimeMillis();
				System.out.println("SQL Execution Time in milliseconds: "
						+ (dt4 - dt3));

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} finally {
				pstmt.close();
				conn.close();
			}
			
			java.lang.Thread.sleep(1000);
			
		}

	}

}
