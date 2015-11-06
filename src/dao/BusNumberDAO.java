package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.BusEntity;
import entity.BusNumberEntity;
import entity.BusStopEntity;
import entity.RouteEntity;

public class BusNumberDAO {
    public ArrayList<BusNumberEntity> getBusNumberList(){
    	ArrayList<BusNumberEntity> list = new ArrayList<BusNumberEntity>();
    	String sql = "select busNumberId, busNumberName, firstTime, lastTime, usable, managerId, to_char(registerdate,'YYYY-MM-DD') as registerdate " +
    			     "from BusNumber";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				BusNumberEntity busNumber = new BusNumberEntity();
				busNumber.setBusNumberId(rs.getInt("busNumberId"));
				busNumber.setBusNumberName(rs.getString("busNumberName"));
				busNumber.setFirstTime(rs.getString("firstTime"));
				busNumber.setLastTime(rs.getString("lastTime"));
				busNumber.setUsable(rs.getString("usable"));
				busNumber.setManagerId(rs.getInt("managerId"));
				busNumber.setRegisterDate(rs.getString("registerdate"));
				
				list.add(busNumber);

			}

		} catch (SQLException e) {
			System.out.println("[BusNumberDAO().getBusNumberList]에서 오류 발생" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return list;
			
    }
    public BusNumberEntity getBusNumber(int busNumberId){
    	BusNumberEntity busNumber = null;
    	
    	String sql ="select busNumberId, busNumberName, firstTime, lastTime, usable, managerId, to_char(registerdate,'YYYY-MM-DD') as registerdate " +
	     "from BusNumber " +
	     "where busNumberId = ?";
    	Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,busNumberId);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				busNumber = new BusNumberEntity();
				
				busNumber.setBusNumberId(busNumberId);
				busNumber.setBusNumberName(rs.getString("busNumberName"));
				busNumber.setFirstTime(rs.getString("firstTime"));
				busNumber.setLastTime(rs.getString("lastTime"));
				busNumber.setUsable(rs.getString("usable"));
				busNumber.setManagerId(rs.getInt("managerId"));
				busNumber.setRegisterDate(rs.getString("registerdate"));
				
			}
		}catch (SQLException e) {
			System.out.println("[BusNumberDAO().getBusNumber]에서 오류 발생" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return busNumber;
    }
    
    public int addBusNumber(BusNumberEntity busNumber){
		
		int affectedRow = 0;
		String sql = "insert into BusNumber(busNumberId, busNumberName, firstTime, lastTime, usable, managerId, registerdate " +
				"values(?, ?, ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, busNumber.getBusNumberId());
			stmt.setString(2, busNumber.getBusNumberName());
			stmt.setString(3, busNumber.getFirstTime());
			stmt.setString(4, busNumber.getLastTime());
			stmt.setString(5, busNumber.getUsable());
			stmt.setInt(6, busNumber.getManagerId());
			stmt.setString(7, busNumber.getRegisterDate());
			
			affectedRow = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[BusNumberDAO.addBusBusNumber]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}
    
    public int updateBusNumber(BusNumberEntity busNumber){
		int affectedRow = 0;
		String sql = "update BusNumber set " +
				"busNumberName=?,firstTime=?,lastTime=?,usable=?, managerId=?,registerdate=? " +
				"where busNumberId=? ";
		Connection con = null;
		PreparedStatement stmt = null;
		
		try{
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, busNumber.getBusNumberName());
			stmt.setString(2, busNumber.getFirstTime());
			stmt.setString(3, busNumber.getLastTime());
			stmt.setString(4, busNumber.getUsable());
			stmt.setInt(5, busNumber.getManagerId());
			stmt.setString(6, busNumber.getRegisterDate());
			stmt.setInt(7, busNumber.getBusNumberId());
			
			affectedRow = stmt.executeUpdate();
			
		}catch(SQLException e){
			System.out.println("[BusNumberDAO.updateBusNumber]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}
    public int deleteBusNumber(int busNumberId){
    	
		int affectedRow = 0;
		String sql = "delete from BusNumber where busNumberId = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, busNumberId);
			
			affectedRow = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[BusNumberDAO.deleteBusNumber]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		
		return affectedRow;
		
	}
    
    public ArrayList<RouteEntity> getRouteList(int busNumberId){

		ArrayList<RouteEntity> list = new ArrayList<RouteEntity>();

		String sql = "select b.busid, bn.busnumberid, bs.stopname, r.timeBetweenStops " + 
					"from bus b, busnumber bn, route r, busstop bs " + 
					"where b.busnumberid = bn.busnumberid and bn.busnumberid = r.busnumberid and " +
					"r.stopcode = bs.stopcode and bn.busnumberid=?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, busNumberId);
			
			rs = stmt.executeQuery();

			while(rs.next()){
				
				BusNumberEntity busNumber = new BusNumberEntity();
				busNumber.setBusNumberId(rs.getInt("busNumberId"));
				
				BusEntity bus = new BusEntity();
				bus.setBusId(rs.getInt("busId"));
				
				busNumber.setBus(bus);
				
				BusStopEntity busStop = new BusStopEntity();
				busStop.setStopName(rs.getString("stopName"));
				
				RouteEntity route = new RouteEntity();
				route.setTimeBetweenStops(rs.getInt("timeBetweenStops"));
				
				route.setBusNumber(busNumber);
				route.setBusStop(busStop);

				list.add(route);
			}
		}catch (SQLException e) {
			System.out.println("[BusStopDAO.getRouteList3]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}

		return list;
	}
    
    
    public ArrayList<RouteEntity> getRouteList2(int busNumberId){
    	ArrayList<RouteEntity> list = new ArrayList<RouteEntity>();
    	String sql = "select bs.stopid, bs.stopname " +
    			     "from busstop bs, route r, busnumber bn " +
    			     "where bs.stopid = r.stopid and r.busnumberid = bn.busnumberid and bn.busnumberid = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, busNumberId);
			
			rs = stmt.executeQuery();

			while(rs.next()){
				
				BusStopEntity busStop = new BusStopEntity();
				busStop.setStopId(rs.getInt("stopId"));
				busStop.setStopName(rs.getString("stopName"));
				
				BusNumberEntity busNumber = new BusNumberEntity();
				busNumber.setBusNumberId(busNumberId);
				
				RouteEntity route = new RouteEntity();
				
				route.setBusNumber(busNumber);
				route.setBusStop(busStop);
				
				
				list.add(route);

			}

		} catch (SQLException e) {
			System.out.println("[BusNumberDAO().getRouteList2]에서 오류 발생" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return list;
    }		
}
