package jdbc;

import java.sql.*;

/*
 * What is the comment? Purely Windchill JDBC Test
 * 
 */

class TheFirstJDBC {
	
	String user = "guest";
	String password = "ts";
	String database = "(DESCRIPTION =(ADDRESS_LIST=(ADDRESS =(PROTOCOL = TCP)(HOST = enux-wnc-102.ptcts.com)(PORT = 1521)))(CONNECT_DATA =(SERVICE_NAME = wind)))";
	//String database="//enux-wnc-102.ptcts.com:1521/wind";
	Connection conn = null;

	
	public void connectToDB() throws Exception{
	System.out.print("Connecting to the database...");
	Class.forName("oracle.jdbc.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@"	+ database, user, password);
	System.out.println("connected.");
	}

	
	public void readRows() throws Exception {

		Statement stmt = null;
		ResultSetMetaData rsmd = null;
		ResultSet rset;
		
	try {

		stmt = conn.createStatement();
		// ResultSet rset = stmt.executeQuery("select 'Hello World' from dual");
		//rset = stmt.executeQuery("select * from wtuser");
		rset = stmt.executeQuery("select * from suppliers"); 
		rsmd = rset.getMetaData();			
		int rsmd_num = rsmd.getColumnCount();
		String str_Tmp = "";

			while (rset.next()) {
				// System.out.format("%20s", rset.getBigDecimal("ida2a2"));
				// System.out.println(" : " + rset.getString("name"));
					for (int i = 1; i <= rsmd_num; i++) {
						str_Tmp = str_Tmp + " : " + rset.getString(i);
					}
					System.out.println(str_Tmp);

			}
		// close the result set, the statement and the connection

		System.out.println("Your JDBC installation is correct.");
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			stmt.close();
			//conn.close();
		}
	
	}
	
	
	public void createTable() throws SQLException {
	    String createString = 
	        "create table " + 
	        "SUPPLIERS " +
	        "(SUP_ID integer NOT NULL, " +
	        "SUP_NAME varchar(40) NOT NULL, " +
	        "STREET varchar(40) NOT NULL, " +
	        "CITY varchar(20) NOT NULL, " +
	        "STATE char(2) NOT NULL, " +
	        "ZIP char(5), " +
	        "PRIMARY KEY (SUP_ID))";

	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(createString);
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println(e.getSQLState());
	        System.out.println(e.getErrorCode());
	        e.printStackTrace();
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	
	public void insertRows () throws SQLException {
	    String insertString = 
	        "insert into  " + 
	        "SUPPLIERS values" +
	        "(0, " +
	        "'PTC', " +
	        "'Pudong', " +
	        "'Shanghai', " +
	        "'SH', " +
	        "'2005' " +
	        ")";
	    System.out.println(insertString);
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(insertString);
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println(e.getSQLState());
	        System.out.println(e.getErrorCode());
	        e.printStackTrace();
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	public static void main(String args[]) throws Exception  {

		TheFirstJDBC tfj = new TheFirstJDBC();
		tfj.connectToDB();
		//tfj.createTable();
		//tfj.test();
		//tfj.insertRows();
		tfj.readRows();
	}

}