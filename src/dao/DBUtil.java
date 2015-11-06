package dao;

import java.sql.*;

public class DBUtil {
	final public static String url = "jdbc:oracle:thin:@192.168.137.2:1521:orcl";
	final public static String id = "team4";
	final public static String password = "team4";
	
	static {
		//�ݵ�� �ѹ��� ����Ǵ� �ڵ� ��
		//System.out.println("static ���� ����Ǿ����ϴ�.");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("[����]����ŬJDBC ����̹��� ã�� �� �����ϴ�.");
		}
	}
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, id, password);
		} catch(SQLException e) {
			System.out.println("[����]DB���ῡ �����Ͽ����ϴ�.");
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
			System.out.println("[����]��ü�� ���� �� �����ϴ�.");
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
			System.out.println("[����]��ü�� ���� �� �����ϴ�.");
			System.out.println(e.getMessage());
		}
	}
}
