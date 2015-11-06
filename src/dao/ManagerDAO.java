package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.ManagerEntity;

public class ManagerDAO {
    public ArrayList<ManagerEntity> getManagerList(){
    	ArrayList<ManagerEntity> list = new ArrayList<ManagerEntity>();
    	
    	String sql = "select managerId, password, name, " +
    			"identification, phone, address, degree, usable " +
    			"from manager";
    	
    	Connection con = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
    	try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				ManagerEntity manager = new ManagerEntity();
				
				manager.setManagerId(rs.getString("managerId"));
				manager.setPassword(rs.getString("password"));
				manager.setName(rs.getString("name"));
				manager.setIdentification(rs.getString("identification"));
				manager.setPhone(rs.getString("phone"));
				manager.setAddress(rs.getString("address"));
				manager.setDegree(rs.getString("degree"));
				manager.setUsable(rs.getString("usable"));
				
				list.add(manager);
				
				System.out.println(list+"list");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con, stmt, rs);
		}
    	
    	
    	return list;
    }
	
    public ManagerEntity getManager(String managerId){
    	ManagerEntity manager = null;
    	String sql = "select password, name, identification, phone, address, degree, usable " +
	                 "from manager where managerId = ? ";
    	Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,managerId);
			rs = stmt.executeQuery();
			if(rs.next()){
				manager = new ManagerEntity();
				
				manager.setPassword(rs.getString("password"));
				manager.setName(rs.getString("name"));
				manager.setIdentification(rs.getString("identification"));
				manager.setPhone(rs.getString("phone"));
				manager.setAddress(rs.getString("address"));
				manager.setDegree(rs.getString("degree"));
				manager.setUsable(rs.getString("usable"));
				manager.setManagerId(managerId);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}finally{
			DBUtil.close(con, stmt, rs);
		}
		return manager;
		
    }
    public int addManager(ManagerEntity manager){
		
		int affectedRow = 0;
		String sql = "insert into Manager(managerId, password, name, identification, phone, address, degree, usable ) " +
				"values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, manager.getManagerId());
			stmt.setString(2, manager.getPassword());
			stmt.setString(3, manager.getName());
			stmt.setString(4, manager.getIdentification());
			stmt.setString(5, manager.getPhone());
			stmt.setString(6, manager.getAddress());
			stmt.setString(7, manager.getDegree());
			stmt.setString(8, manager.getUsable());
			
			affectedRow = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[ManagerDAO.addManager]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}
    public int updateManager(ManagerEntity manager){
		int affectedRow = 0;
		String sql = "update Manager " +
				"set password =?, name =?, identification =?, phone =?, address =?, degree =?, usable =? " +
				"where managerId= ? ";
		Connection con = null;
		PreparedStatement stmt = null;
		
		try{
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, manager.getPassword());
			stmt.setString(2, manager.getName());
			stmt.setString(3, manager.getIdentification());
			stmt.setString(4, manager.getPhone());
			stmt.setString(5, manager.getAddress());
			stmt.setString(6, manager.getDegree());
			stmt.setString(7, manager.getUsable());
			stmt.setString(8, manager.getManagerId());
			
			affectedRow = stmt.executeUpdate();
			
		}catch(SQLException e){
			System.out.println("[ManagerDAO.updateManager]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}
    public int deleteManager(int managerId){
    	
		int affectedRow = 0;
		String sql = "delete from Manager where ManagerId = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, managerId);
			
			affectedRow = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[ManagerDAO.deleteManager]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		
		return affectedRow;
		
	}
}
