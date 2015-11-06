package dao;

import java.sql.*;

public class DBUtil {
	final public static String url = "jdbc:oracle:thin:@192.168.137.2:1521:orcl";
	final public static String id = "team4";
	final public static String password = "team4";
	
	static {
		//반드시 한번만 수행되는 코드 블럭
		//System.out.println("static 블럭이 수행되었습니다.");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("[오류]오라클JDBC 드라이버를 찾을 수 없습니다.");
		}
	}
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, id, password);
		} catch(SQLException e) {
			System.out.println("[오류]DB연결에 실패하였습니다.");
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
			rs = null;
			stmt = null;
			con = null;
		} catch(SQLException e) {
			System.out.println("[오류]객체를 닫을 수 없습니다.");
			System.out.println(e.getMessage());
		}
	}
	
	public static void close(Connection con, PreparedStatement stmt) {
		try {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			stmt = null;
			con = null;
		} catch(SQLException e) {
			System.out.println("[오류]객체를 닫을 수 없습니다.");
			System.out.println(e.getMessage());
		}
	}
}
