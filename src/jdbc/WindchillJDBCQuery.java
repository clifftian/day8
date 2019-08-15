package jdbc;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import oracle.sql.ArrayDescriptor;

/*
 * Test different bind parameters
 */

public class WindchillJDBCQuery {
	
	public Connection getConnection(){
		
		Connection conn = null;
		try {
			String url = "jdbc:oracle:thin:@enux-wnc-102.ptcts.com:1521:wind";
			conn= DriverManager.getConnection(url, "guest", "ts");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
public void QueryWithBindInList(){
		
		try {
			Connection conn=getConnection();		
			PreparedStatement pst = conn.prepareStatement("select * from useragentinfo where daynmb in " +
					" (SELECT /*+ CARDINALITY(wtot 10) */ * FROM TABLE(cast(? as TABLE_OF_NUMBER))) ");
			
			int[] inLists = {11, 30 };
			ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor("TABLE_OF_NUMBER", conn);
			java.sql.Array array_1 = new oracle.sql.ARRAY(arrayDescriptor, conn, inLists);
			pst.setArray(1, array_1);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			ResultSetMetaData rsm = rs.getMetaData();
			
			for (int i=1; i<=rsm.getColumnCount(); i++){
				System.out.printf("%-30s", rsm.getColumnName(i) + "(" + rsm.getColumnTypeName(i) + ")");

			}
			System.out.println();
			while (rs.next()){
				System.out.printf("%-30s", rs.getDate(1));
				System.out.printf("%-30s", rs.getString(2));
				System.out.printf("%-30.30s", rs.getString(3));
				System.out.printf("%-30s", rs.getBigDecimal(4));
				System.out.printf("%-30s", rs.getBigDecimal(5));
				System.out.printf("%-30s", rs.getBigDecimal(6));
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
public void QueryWithBind(){
		
		try {
			Connection conn=getConnection();		
			PreparedStatement pst = conn.prepareStatement("select * from useragentinfo where username in (?, ?)");
			pst.setString(1, "wcadmin");
			pst.setString(2, "261399");
			pst.execute();
			ResultSet rs = pst.getResultSet();
			ResultSetMetaData rsm = rs.getMetaData();
			
			for (int i=1; i<=rsm.getColumnCount(); i++){
				System.out.printf("%-30s", rsm.getColumnName(i) + "(" + rsm.getColumnTypeName(i) + ")");

			}
			System.out.println();
			while (rs.next()){
				System.out.printf("%-30s", rs.getDate(1));
				System.out.printf("%-30s", rs.getString(2));
				System.out.printf("%-30.30s", rs.getString(3));
				System.out.printf("%-30s", rs.getBigDecimal(4));
				System.out.printf("%-30s", rs.getBigDecimal(5));
				System.out.printf("%-30s", rs.getBigDecimal(6));
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void simpleQuery(){
		
		try {
			Connection conn=getConnection();		
			PreparedStatement pst = conn.prepareStatement("select * from useragentinfo where rownum < 10");
			pst.execute();
			ResultSet rs = pst.getResultSet();
			ResultSetMetaData rsm = rs.getMetaData();
			
			for (int i=1; i<=rsm.getColumnCount(); i++){
				System.out.printf("%-30s", rsm.getColumnName(i) + "(" + rsm.getColumnTypeName(i) + ")");

			}
			System.out.println();
			while (rs.next()){
				System.out.printf("%-30s", rs.getTimestamp(1));
				System.out.printf("%-30s", rs.getString(2));
				System.out.printf("%-30.30s", rs.getString(3));
				System.out.printf("%-30s", rs.getBigDecimal(4));
				System.out.printf("%-30s", rs.getBigDecimal(5));
				System.out.printf("%-30s", rs.getBigDecimal(6));
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		WindchillJDBCQuery wjq = new WindchillJDBCQuery();
		wjq.QueryWithBindInList();
		System.out.println("------------------------------");
		wjq.QueryWithBind();
		System.out.println("------------------------------");
		wjq.simpleQuery();

	}

}
